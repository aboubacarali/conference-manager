package fr.formation.conferencemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TalkSummaryDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startTime;
}

