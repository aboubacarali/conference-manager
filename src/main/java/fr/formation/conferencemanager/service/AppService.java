package fr.formation.conferencemanager.service;

import fr.formation.conferencemanager.entity.Conference;
import fr.formation.conferencemanager.entity.Speaker;
import fr.formation.conferencemanager.entity.Talk;
import fr.formation.conferencemanager.repository.ConferenceRepository;
import fr.formation.conferencemanager.repository.SpeakerRepository;
import fr.formation.conferencemanager.repository.TalkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppService {
    private final ConferenceRepository conferenceRepository;
    private final TalkRepository talkRepository;
    private final SpeakerRepository speakerRepository;

    public Speaker addSpeakerToTalk(Long speakerId, Long talkId) {
        Optional<Speaker> speakerToUpdate = speakerRepository.findById(speakerId);
        Optional<Talk> talkToAdd = talkRepository.findById(talkId);
        if (speakerToUpdate.isEmpty() || talkToAdd.isEmpty()) {
            throw new RuntimeException("Speaker or talk doesn't exist");
        }
        speakerToUpdate.get().getTalks().add(talkToAdd.get());
        talkToAdd.get().setSpeaker(speakerToUpdate.get());
        talkRepository.save(talkToAdd.get());
        return speakerRepository.save(speakerToUpdate.get());
    }

    public Conference addTalkToConference(Long conferenceId, Long talkId) {
        Optional<Conference> conferenceToUpdate = conferenceRepository.findById(conferenceId);
        Optional<Talk> talkToAdd = talkRepository.findById(talkId);
        if (conferenceToUpdate.isEmpty() || talkToAdd.isEmpty()) {
            throw new RuntimeException("Conference or talk doesn't exist");
        }
        conferenceToUpdate.get().getTalks().add(talkToAdd.get());
        talkToAdd.get().setConference(conferenceToUpdate.get());
        talkRepository.save(talkToAdd.get());
        return conferenceRepository.save(conferenceToUpdate.get());
    }
}
