package fr.formation.conferencemanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "speakers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    @OneToMany
    private List<Talk> talks;
}
