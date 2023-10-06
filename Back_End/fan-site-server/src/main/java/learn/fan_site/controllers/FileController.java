package learn.fan_site.controllers;

import learn.fan_site.domain.FileService;
import learn.fan_site.domain.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import learn.fan_site.domain.FileService;

@RestController
@RequestMapping("/api/file")

public class FileController {

    private final FileService service;

    public FileController(FileService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file, @RequestParam("description") String description) {
        Result<String> result = service.uploadFile(file, description);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
    }
}

//    @PostMapping
//    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file) {
//        Result<String> result = service.uploadFile(file);
//        if (result.isSuccess()) {
//            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
//    }
//}


