import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UploadController {

    private final List<String> images = new ArrayList<>();

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("description") String description) throws IOException {
        File convertFile = new File("./uploads/" + file.getOriginalFilename());
        convertFile.createNewFile();
//        file.transferTo(convertFile);
        return "File uploaded";
    }

    @GetMapping("/images")
    public List<String> listImages() {
        return images;
    }
}
