package com.reus.pastebin.repository;

import com.reus.pastebin.model.Paste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface PasteRepository extends JpaRepository<Paste, Long> {
    Optional<Paste> findByHashAndExpiresAtAfter(String hash, OffsetDateTime now);
}