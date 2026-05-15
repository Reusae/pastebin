package com.reus.pastebin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreatePasteRequest {
    @Size(max = 255, message = "Title too long")
    private String title;

    @NotBlank(message = "Content cannot be empty")
    private String content;

    @Positive(message = "Expiration time must be positive")
    private Integer expiresInMinutes;

    private Boolean isPublic;
}
