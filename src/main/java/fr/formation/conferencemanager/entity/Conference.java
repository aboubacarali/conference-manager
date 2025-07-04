package fr.formation.conferencemanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "conferences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    @OneToMany(mappedBy = "conference")
    private List<Talk> talks;
}
