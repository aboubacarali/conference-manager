package fr.formation.conferencemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalkDetailDto {

    private String title;
    private String description;
    private LocalDateTime startTime;
    private SpeakerDto speaker;
}
