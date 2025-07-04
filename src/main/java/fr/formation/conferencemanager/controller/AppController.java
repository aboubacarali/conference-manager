package fr.formation.conferencemanager.controller;

import fr.formation.conferencemanager.entity.Conference;
import fr.formation.conferencemanager.entity.Speaker;
import fr.formation.conferencemanager.entity.Talk;
import fr.formation.conferencemanager.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/talk/{talkId}")
    public ResponseEntity<Talk> showTalk(@PathVariable Long talkId) {
        return ResponseEntity.ok(appService.viewTalk(talkId));
    }
}
