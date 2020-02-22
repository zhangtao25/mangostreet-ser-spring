package com.mangostreet.mangostreetserspring.controller;


import com.mangostreet.mangostreetserspring.VO.ResultVO;
import com.mangostreet.mangostreetserspring.dataobject.User;
import com.mangostreet.mangostreetserspring.utils.ResultVOUtil;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadImageController {
    @PostMapping("/test")
    public ResultVO upload (@RequestParam("file_data") MultipartFile multipartFile){

        final String path = "/Users/zhangtao25/Desktop";
        final String name = "tttttlogo.png";

        File newFile=new File(path+"/"+name);

        try {
            multipartFile.transferTo(newFile);//文件上传
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(multipartFile);
        final String filePath = "/Users/zhangtao25/Desktop";
        final String fileName = "logo.png";
        final String url = "http://localhost:3000/users/note";

        RestTemplate restTemplate = new RestTemplate();

        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);

        //设置请求体，注意是LinkedMultiValueMap
        FileSystemResource fileSystemResource = new FileSystemResource(path+"/"+name);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("note", fileSystemResource);
        form.add("filename",fileName);

        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);

        String s = restTemplate.postForObject(url, files, String.class);

        return ResultVOUtil.success(s);
    }
}
