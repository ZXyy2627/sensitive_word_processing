package com.brilliance.sensitive_word_processing.contorller;

import com.brilliance.sensitive_word_processing.service.ReadFileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.LineNumberReader;

@Controller
public class ReadFileController {

    @Autowired
    private ReadFileService readFileService;

    @ApiOperation("跳转到上传文件页面")
    @GetMapping("/toLoadFile")
    public String toLoadFile(){
        return "loadFile";
    }

    @ApiOperation("读取文件")
    @PostMapping("/a")
    public String readFile(@RequestParam("file") MultipartFile file){
        try {
            readFileService.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
