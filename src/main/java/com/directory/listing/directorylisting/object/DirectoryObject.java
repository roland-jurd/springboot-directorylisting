package com.directory.listing.directorylisting.object;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DirectoryObject implements Serializable {
    
    String path;
    String size;
    String type;
    String hidden;
    String creationTime;
    String lastModifiedTime;
    String lastAccessedTime;
    
    
    
    public static DirectoryObject fromPath(Path path) {
        DirectoryObject obj = new DirectoryObject();
        File file = path.toFile();
        
        
        obj.setPath(file.getAbsolutePath());
        obj.setSize(String.format("%,d bytes", file.length()));
        obj.setType(file.isFile() ? "File" : "Folder");
        obj.setHidden(file.isHidden() ? "yes" : "no");
        
        BasicFileAttributeView view
                = Files.getFileAttributeView(
                path, BasicFileAttributeView.class);
        
        try {
            obj.setCreationTime(view.readAttributes().creationTime().toString());
            obj.setLastModifiedTime(view.readAttributes().lastModifiedTime().toString());
            obj.setLastAccessedTime(view.readAttributes().lastAccessTime().toString());
        }catch (IOException e) {
        
        }

        return obj;
    }
    
    
}
