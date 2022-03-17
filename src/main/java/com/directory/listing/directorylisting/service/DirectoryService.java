package com.directory.listing.directorylisting.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.jni.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.directory.listing.directorylisting.aspect.DirectoryAspect;
import com.directory.listing.directorylisting.object.DirectoryObject;


@Service
public class DirectoryService {
    
    @Autowired
    DirectoryAspect aspect;
    
    private List<Path> getDirectoryListing(String path) throws IOException {
        return Files.list(Paths.get(path))
                .map(Path::toAbsolutePath)
                .collect(Collectors.toList());
    }
    
    public List<DirectoryObject> getPathResults(String path) {
        aspect.validateInput(path);
        
        try {
            return getDirectoryListing(path)
                    .stream()
                    .map(DirectoryObject::fromPath)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return null;
    }

}
