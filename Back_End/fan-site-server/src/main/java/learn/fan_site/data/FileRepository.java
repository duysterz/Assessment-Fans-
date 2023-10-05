package learn.fan_site.data;

import learn.fan_site.exceptions.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface FileRepository {
    String upload(MultipartFile file) throws FileUploadException;
}