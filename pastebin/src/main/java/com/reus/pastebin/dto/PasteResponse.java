package com.reus.pastebin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class PasteResponse {
    private String title;

    private String content;

    private OffsetDateTime createdAt;

    private OffsetDateTime expiresAt;

    private String hash;
}
