package com.zepic.captiongenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/v1/caption")
@RestController
@RequiredArgsConstructor
public class CaptionController {

    private final CaptionService captionService;

    @PostMapping
    public ResponseEntity<String> generateCaption(@Valid @RequestBody CaptionRequest captionRequest) throws JsonProcessingException {
        return ResponseEntity.ok(captionService.generateCaption(captionRequest.getImageUrl()));
    }

}
