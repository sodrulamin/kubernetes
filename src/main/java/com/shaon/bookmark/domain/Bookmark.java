package com.shaon.bookmark.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table (name = "bookmarks")
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false)
    private String url;

    private Instant createdAt;
}
