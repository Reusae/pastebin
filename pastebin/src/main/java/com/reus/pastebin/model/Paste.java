package com.reus.pastebin.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "pastes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String hash;

    @Column(name = "s3_key", nullable = false)
    private String s3Key;

    @Column(length = 255)
    private String title;

    @Column(name = "expires_at", nullable = false)
    private OffsetDateTime expiresAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "is_public", nullable = false)
    private boolean isPublic;
}