package com.brilliance.sensitive_word_processing.service.impl;

import com.brilliance.sensitive_word_processing.service.ReadFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service("readFileService")
public class ReadFileServiceImpl implements ReadFileService {
    @Override
    public void readFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileType = "";
        if(fileName!= null && fileName.contains(".")){
            int point = fileName.lastIndexOf('.');
            fileType = fileName.substring(point+1);
        }
        if("txt".equals(fileType)){
            //handlerSensitiveOfTxt(file);
        }else{
            //handlerSensitiveOfExcel(file);
        }
        System.out.println(fileName);

        long size = file.getSize();
//        ExecutorService exec = Executors.newFixedThreadPool(10);
        InputStreamReader isr = new InputStreamReader(file.getInputStream());
        LineNumberReader lnr = new LineNumberReader(isr);
        lnr.skip(Long.MAX_VALUE);
        long lineNumber = lnr.getLineNumber()+1;
        System.out.println("文件总行数为："+lineNumber);
        //获取文件总行数，然后进行分片
    }
}
