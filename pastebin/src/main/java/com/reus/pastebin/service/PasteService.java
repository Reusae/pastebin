package com.reus.pastebin.service;

import com.reus.pastebin.dto.CreatePasteRequest;
import com.reus.pastebin.dto.PasteResponse;
import com.reus.pastebin.model.Paste;
import com.reus.pastebin.repository.PasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class PasteService {

    private final PasteRepository pasteRepository;

    private final Map<String, String> contentStore = new ConcurrentHashMap<>();

    public PasteResponse createPaste(CreatePasteRequest request) {
        String hash = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        OffsetDateTime now = OffsetDateTime.now();
        int expirationMinutes = request.getExpiresInMinutes() != null
                ? request.getExpiresInMinutes() : 1440;

        Paste paste = Paste.builder()
                .hash(hash)
                .s3Key("pastes/" + hash)
                .title(request.getTitle())
                .isPublic(request.getIsPublic() != null ? request.getIsPublic() : false)
                .createdAt(now)
                .expiresAt(now.plusMinutes(expirationMinutes))
                .build();

        Paste savedPaste = pasteRepository.save(paste);
        contentStore.put(hash, request.getContent());

        return PasteResponse.builder()
                .hash(savedPaste.getHash())
                .title(savedPaste.getTitle())
                .content(request.getContent())
                .createdAt(savedPaste.getCreatedAt())
                .expiresAt(savedPaste.getExpiresAt())
                .build();
    }

    public PasteResponse getPaste(String hash) {
        Paste paste = pasteRepository.findByHashAndExpiresAtAfter(hash, OffsetDateTime.now())
                .orElseThrow(() -> new RuntimeException("Paste not found or expired"));

        String content = contentStore.get(hash);

        if (content == null) {
            throw new RuntimeException("Paste content not found");
        }

        return PasteResponse.builder()
                .hash(paste.getHash())
                .title(paste.getTitle())
                .content(content)
                .createdAt(paste.getCreatedAt())
                .expiresAt(paste.getExpiresAt())
                .build();
    }
}