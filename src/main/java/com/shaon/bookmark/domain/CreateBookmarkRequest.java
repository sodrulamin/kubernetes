package com.shaon.bookmark.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateBookmarkRequest {
    @NotBlank(message = "Title should not be empty")
    private String title;
    @NotBlank(message = "Url should not be empty")
    private String url;
}