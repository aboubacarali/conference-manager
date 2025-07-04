package fr.formation.conferencemanager.controller;

import fr.formation.conferencemanager.dto.TalkDetailDto;
import fr.formation.conferencemanager.service.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/talks")
public class TalkController {
    private final TalkService talkService;

    @GetMapping("/{talkId}")
    public ResponseEntity<TalkDetailDto> getTalkDetail(@PathVariable Long talkId) {
        return ResponseEntity.ok(talkService.getTalkDetail(talkId));
    }
}
