package com.directory.listing.directorylisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.directory.listing.directorylisting.response.SearchResponse;
import com.directory.listing.directorylisting.object.DirectoryObject;
import com.directory.listing.directorylisting.service.DirectoryService;
import com.directory.listing.directorylisting.helper.SearchResultHelper;


@RestController
@RequestMapping("/directory")
public class DirectoryController {
    
    @Autowired
    DirectoryService directoryService;
    
    @GetMapping("/test")
    public String test() {
        return "Directory Controller Test";
    }
    
    @GetMapping("/search")
    public SearchResponse search(@RequestParam String path, @RequestParam(required = false, defaultValue = "1000") int limit, @RequestParam(required = false, defaultValue = "0") int offset) {
        List<DirectoryObject> files = null;
        try {
            files = directoryService.getPathResults(path);
        }catch (Exception e) {
        
        }
        
       return SearchResultHelper.getSearchResult(files, offset, limit);
    }
    
}
