package com.movieflix.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService{

    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {

        //get Name of the File
        String fileName = file.getOriginalFilename();

        //to get the file Path
        String filePath = path + File.separator + fileName;

        // We Have to Create a File Object
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        //copy the file or upload file to the Path
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }

    @Override
    public InputStream getResourceFile(String path, String filename) throws FileNotFoundException {

        //Get The file Path from the
        String filePath = path + File.separator + filename;

        return new FileInputStream(filePath);
    }
}
