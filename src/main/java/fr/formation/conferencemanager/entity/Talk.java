package fr.formation.conferencemanager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "talks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Talk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startTime;
//    private LocalDateTime endDate;
    @ManyToOne
    private Conference conference;
    @ManyToOne
    @JsonBackReference
    private Speaker speaker;
}
