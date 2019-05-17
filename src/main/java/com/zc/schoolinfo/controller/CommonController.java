package com.zc.schoolinfo.controller;

import com.zc.schoolinfo.common.WebApiResult;
import com.zc.schoolinfo.model.enums.WebApiResultCodeEnum;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/24 18:19
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/common")
public class CommonController {

    @PostMapping("/singleUpload")
    public WebApiResult singleFileUpload(@RequestParam("file")MultipartFile file){
        if (file.isEmpty()){
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        Path filepath=null;
        try {
            byte[] bytes = file.getBytes();
            filepath = Paths.get(uploadDirectory()+file.getOriginalFilename());
            Files.write(filepath, bytes);
            System.out.println("上传："+file.getOriginalFilename());
        } catch (IOException e) {
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess("/api/static/"+file.getOriginalFilename());

    }

    @PostMapping("/multiUpload")
    public WebApiResult multipleFileUpload(@RequestParam("files")MultipartFile[] files){
        if (files==null||files.length==0){
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        List<Map<String, Object>> filelist = new ArrayList<>();
        for (MultipartFile file:files){
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(uploadDirectory()+file.getOriginalFilename());
                Files.write(path, bytes);
                Map<String, Object> fileUrl = new HashMap<>();
                fileUrl.put("name", file.getOriginalFilename());
                fileUrl.put("url", "/api/static/" + file.getOriginalFilename());
                filelist.add(fileUrl);
                System.out.println("上传："+file.getOriginalFilename());
            } catch (IOException e) {
                return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
            }
        }
        if (files.length == 1) {
            return WebApiResult.buildSuccess("/api/static/"+files[0].getOriginalFilename());
        }

        return WebApiResult.buildSuccess(filelist);

    }

    private String uploadDirectory() throws FileNotFoundException {
        //获取根目录
//        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File path = new File("E:/xyhdxx_file");

        //如果上传目录为/static/images/upload/，则可以如下获取：
        File upload = new File(path.getAbsolutePath(),"/xyhdxx/upload/");
        if(!upload.exists()) upload.mkdirs();

        //在开发测试模式时，得到的地址为：{项目跟目录}/target/static/images/upload/
        //在打包成jar正式发布时，得到的地址为：{发布jar包目录}/static/images/upload/
        return upload.getAbsolutePath()+File.separator;
    }
}
