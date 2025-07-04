package fr.formation.conferencemanager.controller;

import fr.formation.conferencemanager.entity.Conference;
import fr.formation.conferencemanager.entity.Speaker;
import fr.formation.conferencemanager.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AppController {
    private final AppService appService;

    @PostMapping("/speaker/{speakerId}/assign-talk/{talkId}")
    public ResponseEntity<Speaker> addSpeakerToTalk(@PathVariable Long speakerId, @PathVariable Long talkId) {
        return ResponseEntity.ok(appService.addSpeakerToTalk(speakerId, talkId));
    }


    @PostMapping("/conference/{conferenceId}/add-talk/{talkId}")
    public ResponseEntity<Conference> addTalkToConference(@PathVariable Long conferenceId, @PathVariable Long talkId) {
        return ResponseEntity.ok(appService.addTalkToConference(conferenceId, talkId));
    }
}
