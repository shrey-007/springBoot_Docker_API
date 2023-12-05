package com.example.api.controller;

import com.example.api.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
    @Autowired
    FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        System.out.println(file.getOriginalFilename());
        try{
             boolean flag=fileUploadHelper.uploadFile(file);
             if(flag){
                 return ResponseEntity.ok("File is successfully uploaded");
             }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong ! Try again");
    }
}
