package com.directory.listing.directorylisting.helper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.directory.listing.directorylisting.object.DirectoryObject;
import com.directory.listing.directorylisting.response.SearchResponse;


class SearchResultHelperTest {
    
    List<DirectoryObject> items;
    
    @BeforeEach
    void setUp() {
        items = new ArrayList<>();
        items.add(new DirectoryObject("/test", "100", "File", "No", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z"));
        items.add(new DirectoryObject("/test2", "100", "File", "No", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z"));
        items.add(new DirectoryObject("/test3", "100", "File", "No", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z"));
        items.add(new DirectoryObject("/test4", "100", "File", "No", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z"));
        items.add(new DirectoryObject("/test5", "100", "File", "No", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z"));
        items.add(new DirectoryObject("/test6", "100", "File", "No", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z"));
        items.add(new DirectoryObject("/test7", "100", "File", "No", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z"));
        items.add(new DirectoryObject("/test8", "100", "File", "No", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z"));
        items.add(new DirectoryObject("/test9", "100", "File", "No", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z", "2022-03-16T07:51:41Z"));
    }
    
    @Test
    public void test_getSearchResult_withLimit() {
        //given
        int limit = 5;
        
        //when
        SearchResponse result = SearchResultHelper.getSearchResult(items, limit);
        
        //then
        assertEquals(limit, result.getTotalCount());
        assertEquals(limit, result.getCount());
        assertEquals(limit, result.getItems().size());
    }
    
    @Test
    public void test_getSearchResult_withLimitOverResult() {
        //given
        int limit = 1000;
        int itemsCount = items.size();
        
        //when
        SearchResponse result = SearchResultHelper.getSearchResult(items, limit);
        
        //then
        assertEquals(itemsCount, result.getTotalCount());
        assertEquals(itemsCount, result.getCount());
        assertEquals(itemsCount, result.getItems().size());
    }
    
    @Test
    public void test_getSearchResult_withLimitOffset() {
        //given
        int limit = 5;
        int offset = 6;
        int itemsCount = items.size() - offset;
        
        //when
        SearchResponse result = SearchResultHelper.getSearchResult(items, limit, offset);
        
        //then
        assertEquals(items.size(), result.getTotalCount());
        assertEquals(itemsCount, result.getCount());
        assertEquals(itemsCount, result.getItems().size());
    }
}