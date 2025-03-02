package com.shaon.bookmark.controller;

import com.shaon.bookmark.domain.Bookmark;
import com.shaon.bookmark.domain.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})
class BookmarkControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BookmarkRepository bookmarkRepository;

    private List<Bookmark> bookmarkList;

    @BeforeEach
    void setUp (){
        bookmarkRepository.deleteAllInBatch();

        bookmarkList = new ArrayList<>();

        bookmarkList.add(new Bookmark(null, "Bookmark 1", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 2", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 3", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 4", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 5", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 6", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 7", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 8", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 9", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 10", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 11", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 12", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 13", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 14", "https://example.com/lab", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Bookmark 15", "https://example.com/lab", Instant.now()));

        bookmarkRepository.saveAll(bookmarkList);
    }

    @ParameterizedTest
    @CsvSource ({
            "1, 15, 2, 1, true, false, true, false",
            "2, 15, 2, 2, false, true, false, true"
    })
    void shouldGetBookmarks(int pageNumber, int totalElements, int totalPages, int currentPage, boolean isFirst,
                            boolean isLast, boolean hasNext, boolean hasPrev) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/bookmarks?page=" + pageNumber))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
                .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst)))
                .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast)))
                .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
                .andExpect(jsonPath("$.hasPrev", CoreMatchers.equalTo(hasPrev)))
        ;
    }

    @Test
    void shouldCreateBookmarkSuccessfully() throws Exception {
        this.mvc.perform(
                        post("/api/bookmarks")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
            {
                "title": "SivaLabs Blog",
                "url": "https://sivalabs.in"
            }
            """)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.title", is("SivaLabs Blog")))
                .andExpect(jsonPath("$.url", is("https://sivalabs.in")));
    }

    @Test
    void shouldFailToCreateBookmarkWhenUrlIsNotPresent() throws Exception {
        this.mvc.perform(
                        post("/api/bookmarks")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                {
                    "title": "SivaLabs Blog"
                }
                """)
                )
                .andExpect(status().isBadRequest())
                .andExpect(header().string("Content-Type", is("application/problem+json")))
                .andExpect(jsonPath("$.type", is("https://zalando.github.io/problem/constraint-violation")))
                .andExpect(jsonPath("$.title", is("Constraint Violation")))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.violations", hasSize(1)))
                .andExpect(jsonPath("$.violations[0].field", is("url")))
                .andExpect(jsonPath("$.violations[0].message", is("Url should not be empty")))
                .andReturn();
    }
}