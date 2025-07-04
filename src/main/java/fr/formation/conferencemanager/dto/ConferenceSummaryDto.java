package fr.formation.conferencemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceSummaryDto {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private List<TalkSummaryDto> talks;
}
