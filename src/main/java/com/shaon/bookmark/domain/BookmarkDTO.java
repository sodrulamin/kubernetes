package com.shaon.bookmark.domain;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class BookmarkDTO {

    private Long id;

    private String title;

    private String url;

    private Instant createdAt;
}
