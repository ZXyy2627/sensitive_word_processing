package com.brilliance.sensitive_word_processing.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface ReadFileService {
    public void readFile(MultipartFile file) throws IOException;
}
