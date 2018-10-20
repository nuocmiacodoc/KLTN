package com.packt.webbi.service.impl;

import com.packt.webbi.domain.repository.FileUploadRepository;
import com.packt.webbi.exception.FileStorageException;
import com.packt.webbi.exception.MyFileNotFoundException;
import com.packt.webbi.properties.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;
    
    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file, String userName, String tableName) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            
            System.out.println(targetLocation.toString());
            
            String[] csvHeader = getCsvHerder(targetLocation.toString());
            
            fileUploadRepository.createMySQLTable(userName, tableName, csvHeader);
            
            fileUploadRepository.loadCsvFileToDB(userName, tableName, targetLocation.toString(), csvHeader);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
    
    public String[] getCsvHerder(String fileLocation) {
    	String line;
    	String[] strArray;
    	try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
			line = br.readLine();
			strArray = line.split(",");
			System.out.println(Arrays.toString(strArray));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    	return strArray;
    } 
}
