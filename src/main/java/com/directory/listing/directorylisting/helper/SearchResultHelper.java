package com.directory.listing.directorylisting.helper;

import java.util.List;

import com.directory.listing.directorylisting.object.DirectoryObject;
import com.directory.listing.directorylisting.response.SearchResponse;


public class SearchResultHelper {
    
    public static SearchResponse getSearchResult(List<DirectoryObject> searchResult, int limit, int offset) {
        int min = Integer.min(searchResult.size(), offset + limit);
    
        if (searchResult.size() > offset) {
            return new SearchResponse(searchResult.subList(offset, min), offset, min);
        }
    
        return new SearchResponse(searchResult.subList(0, min), offset, min);
    }
    
    public static SearchResponse getSearchResult(List<DirectoryObject> searchResult, int limit) {
        int min = Integer.min(searchResult.size(), limit);
        return new SearchResponse(searchResult.subList(0, min), 0, min);
    }
}
