package fr.formation.conferencemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeakerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
}
