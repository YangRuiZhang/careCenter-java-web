package com.seu.care.customer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${web.upload-path}")
    private String path;

    @RequestMapping("upload")
    public String upload(MultipartFile file){
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        try {
            //复制照片
            FileOutputStream fileOutputStream = new FileOutputStream(path + filename);
            FileCopyUtils.copy(file.getInputStream(),fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }
}
