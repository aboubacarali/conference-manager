package fr.formation.conferencemanager.controller;

import fr.formation.conferencemanager.dto.ConferenceSummaryDto;
import fr.formation.conferencemanager.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/conferences")

public class ConferenceController {
    private final ConferenceService conferenceService;

    @GetMapping
    public ResponseEntity<List<ConferenceSummaryDto>> getConferences() {
        return ResponseEntity.ok(conferenceService.getConferences());
    }
}
