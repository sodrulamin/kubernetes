package com.shaon.bookmark;

import com.shaon.bookmark.domain.Bookmark;
import com.shaon.bookmark.domain.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(String... args) throws Exception {
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 1", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 2", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 3", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 4", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 5", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 6", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 7", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 8", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 9", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 10", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 11", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 12", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 13", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 14", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring Blog 15", "https://spring.io/blog", Instant.now()));
    }
}
