package com.reus.pastebin.api;

import com.reus.pastebin.dto.CreatePasteRequest;
import com.reus.pastebin.dto.PasteResponse;
import com.reus.pastebin.service.PasteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pastes")
@RequiredArgsConstructor
public class PasteController {

    private final PasteService pasteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PasteResponse createPaste(@Valid @RequestBody CreatePasteRequest request) {
        return pasteService.createPaste(request);
    }

    @GetMapping("/{hash}")
    public PasteResponse getPaste(@PathVariable String hash) {
        return pasteService.getPaste(hash);
    }
}