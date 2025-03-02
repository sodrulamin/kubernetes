package com.shaon.bookmark.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final BookmarkMapper bookmarkMapper;

    @Transactional (readOnly = true)
    public BookmarksDTO getAllBookmarks (Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");

//        Page<BookmarkDTO> bookmarkPage = bookmarkRepository.findAll(pageable).map(bookmarkMapper::toDto);
        Page<BookmarkDTO> bookmarkPage = bookmarkRepository.findBookmarks(pageable);

        return new BookmarksDTO(bookmarkPage);
    }

    public BookmarksDTO searchBookmarks(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");

//        Page<BookmarkDTO> bookmarkPage = bookmarkRepository.searchBookmarks(query, pageable);
        Page<BookmarkDTO> bookmarkPage = bookmarkRepository.findByTitleContainsIgnoreCase(query, pageable);

        return new BookmarksDTO(bookmarkPage);
    }
}
