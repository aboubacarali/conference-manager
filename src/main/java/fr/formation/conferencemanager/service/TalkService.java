package fr.formation.conferencemanager.service;

import fr.formation.conferencemanager.dto.SpeakerDto;
import fr.formation.conferencemanager.dto.TalkDetailDto;
import fr.formation.conferencemanager.entity.Talk;
import fr.formation.conferencemanager.repository.TalkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TalkService {
    private final TalkRepository talkRepository;

    public TalkDetailDto getTalkDetail(Long id) {
        Talk talk = talkRepository.findById(id).orElse(null);
        assert talk != null;
        return new TalkDetailDto(
                talk.getTitle(),
                talk.getDescription(),
                talk.getStartTime(),
                new SpeakerDto(
                        talk.getSpeaker().getId(),
                        talk.getSpeaker().getFirstName(),
                        talk.getSpeaker().getLastName(),
                        talk.getSpeaker().getBio()
                )
        );
    }
}
