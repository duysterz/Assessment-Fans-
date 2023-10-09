package learn.fan_site.data;

import learn.fan_site.exceptions.FileUploadException;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import learn.fan_site.models.ImageData;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.util.ArrayList;
import java.util.List;

@Component
public class S3FileRepository implements FileRepository {

    public final static int MAX_IMAGE_WIDTH = 1200;

    private final String accessKeyId;
    private final String secretAccessKey;
    private final String bucketName;
    private final Region bucketRegion;
    private final AwsBasicCredentials awsCredentials;
    private final AwsCredentialsProvider credentialsProvider;
    private final S3Client s3Client;



    public S3FileRepository(
            @Value("${aws.access.key.id}") String accessKeyId,
            @Value("${aws.secret.access.key}") String secretAccessKey,
            @Value("${aws.s3.bucket.name}") String bucketName,
            @Value("${aws.s3.bucket.region}") String bucketRegion) {
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.bucketName = bucketName;
        this.bucketRegion = Region.of(bucketRegion);

        AwsCredentials awsCredentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);

        this.awsCredentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);
        this.credentialsProvider = StaticCredentialsProvider.create(awsCredentials);

        this.s3Client = S3Client.builder()
                .region(this.bucketRegion)
                .credentialsProvider(this.credentialsProvider)
                .build();
    }

    private S3Client buildS3Client() {
        return S3Client.builder()
                .region(this.bucketRegion)
                .credentialsProvider(this.credentialsProvider)
                .build();
    }

    @Override
    public String upload(MultipartFile file, String description) throws FileUploadException {
        try {
            return upload(ImageIO.read(file.getInputStream()), file.getOriginalFilename(), file.getContentType());
        } catch (IOException | S3Exception ex) {
            throw new FileUploadException(ex.getMessage(), ex);
        }
    }


    @Override
    public List<ImageData> fetchAllImages() {
        List<ImageData> imageList = new ArrayList<>();

        try (S3Client s3 = buildS3Client()) {
            ListObjectsV2Request listReq = ListObjectsV2Request.builder()
                    .bucket(bucketName)
                    .build();

            ListObjectsV2Response listRes = s3.listObjectsV2(listReq);

            for (S3Object s3Object : listRes.contents()) {
                String filename = s3Object.key();
                URL url = s3.utilities().getUrl(builder -> builder.bucket(bucketName).key(filename));


                // logic to get URL from S3 upload
//                String description = fetchDescriptionFromDatabase(filename);

                ImageData imageData = new ImageData();
                imageData.setId(filename);  // ID can be filename or some unique identifier
                imageData.setUrl(url.toString());
                imageData.setDescription(description);

                imageList.add(imageData);
            }
        }
        return imageList;
    }




    // Placeholder method, replace with real database fetch logic
    private String fetchDescriptionFromDatabase(String filename) {
        // Fetch description based on filename or some identifier
        return "Description for " + filename;
    }

    

    private String upload(BufferedImage image, String filename, String contentType) throws FileUploadException {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretAccessKey);

        try (S3Client s3 = S3Client.builder()
                .region(bucketRegion)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build()) {

            if (image.getWidth() > MAX_IMAGE_WIDTH) {
                image = resizeImage(image);
            }

            PutObjectRequest request = buildS3PutRequest(filename, contentType);
            RequestBody requestBody = convertImageToRequestBody(filename, image);

            PutObjectResponse response = s3.putObject(request, requestBody);

            return s3.utilities().getUrl(builder -> builder.bucket(bucketName).key(filename)).toString();
        } catch (IOException | S3Exception ex) {
            throw new FileUploadException(ex.getMessage(), ex);
        }
    }

    private PutObjectRequest buildS3PutRequest(String filename, String contentType) {
        return PutObjectRequest.builder()
                .bucket(bucketName)
                .key(filename)
                .contentType(contentType)
                .build();
    }

    private RequestBody convertImageToRequestBody(String filename, BufferedImage image) throws IOException {
        String extension = filename.substring(filename.lastIndexOf(".") + 1);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, extension, outputStream);
        byte[] bytes = outputStream.toByteArray();
        return RequestBody.fromBytes(bytes);
    }

    private BufferedImage resizeImage(BufferedImage original) {
        return Scalr.resize(original, MAX_IMAGE_WIDTH);
    }
}