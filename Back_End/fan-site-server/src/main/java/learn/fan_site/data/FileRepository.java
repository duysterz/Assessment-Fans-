package learn.fan_site.data;

import learn.fan_site.exceptions.FileUploadException;
import learn.fan_site.models.ImageData;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileRepository {
    String upload(MultipartFile file, String description) throws FileUploadException;
    //    String upload(MultipartFile file) throws FileUploadException;
    List<ImageData> fetchAllImages();
}