package com.shaon.bookmark.controller;

import com.shaon.bookmark.domain.Bookmark;
import com.shaon.bookmark.domain.BookmarkService;
import com.shaon.bookmark.domain.BookmarksDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDTO getBookmarks (@RequestParam (name = "page", defaultValue = "1") Integer page,
                                      @RequestParam (name = "query", defaultValue = "") String query) {
        if(query == null || query.isBlank())
            return bookmarkService.getAllBookmarks(page);

        return bookmarkService.searchBookmarks(query, page);
    }
}
