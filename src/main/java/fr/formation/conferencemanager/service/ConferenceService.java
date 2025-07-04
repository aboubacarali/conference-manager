package fr.formation.conferencemanager.service;

import fr.formation.conferencemanager.dto.ConferenceSummaryDto;
import fr.formation.conferencemanager.dto.TalkSummaryDto;
import fr.formation.conferencemanager.entity.Conference;
import fr.formation.conferencemanager.repository.ConferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;

    public List<ConferenceSummaryDto> getConferences() {
        List<Conference> conferences = conferenceRepository.findAll();
        return conferences.stream()
                .map(conference -> new ConferenceSummaryDto(
                        conference.getId(),
                        conference.getName(),
                        conference.getStartDate(),
                        conference.getEndDate(),
                        conference.getLocation(),
                        conference.getTalks()
                                .stream()
                                .map(talk -> new TalkSummaryDto(
                                        talk.getId(),
                                        talk.getTitle(),
                                        talk.getDescription(),
                                        talk.getStartTime()
                                ))
                                .collect(Collectors.toList())
                        )).collect(Collectors.toList());
    }
}
