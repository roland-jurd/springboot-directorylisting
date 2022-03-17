package com.directory.listing.directorylisting.response;

import java.io.Serializable;
import java.util.List;

import com.directory.listing.directorylisting.object.DirectoryObject;
import lombok.Getter;


@Getter
public class SearchResponse implements Serializable {
    
    final int count;
    final int offset;
    final int totalCount;
    final List<DirectoryObject> items;
    
    public SearchResponse(List<DirectoryObject> items, int offset, int totalCount) {
        this.count = items.size();
        this.offset = offset + 1;
        this.totalCount = totalCount;
        this.items = items;
    }
}
