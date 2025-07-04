package fr.formation.conferencemanager.config;

import fr.formation.conferencemanager.entity.Conference;
import fr.formation.conferencemanager.entity.Speaker;
import fr.formation.conferencemanager.entity.Talk;
import fr.formation.conferencemanager.repository.ConferenceRepository;
import fr.formation.conferencemanager.repository.SpeakerRepository;
import fr.formation.conferencemanager.repository.TalkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class DataInitializer implements CommandLineRunner {

    private final SpeakerRepository speakerRepository;
    private final ConferenceRepository conferenceRepository;
    private final TalkRepository talkRepository;

    public DataInitializer(SpeakerRepository speakerRepository,
                           ConferenceRepository conferenceRepository,
                           TalkRepository talkRepository) {
        this.speakerRepository = speakerRepository;
        this.conferenceRepository = conferenceRepository;
        this.talkRepository = talkRepository;
    }

    @Override
    public void run(String... args) {
        // Création des speakers
        Speaker james = new Speaker(null, "James", "Gosling", "Le père de Java.", new ArrayList<>());
        Speaker gavin = new Speaker(null, "Gavin", "King", "Créateur de Hibernate.", new ArrayList<>());
        speakerRepository.save(james);
        speakerRepository.save(gavin);

        // Création des conférences
        Conference devoxx = new Conference(null, "Devoxx France 2024",
                LocalDate.of(2024, 4, 17),
                LocalDate.of(2024, 4, 19),
                "Paris", new ArrayList<>());

        Conference springIO = new Conference(null, "Spring I/O 2024",
                LocalDate.of(2024, 5, 30),
                LocalDate.of(2024, 5, 31),
                "Barcelone", new ArrayList<>());

        conferenceRepository.save(devoxx);
        conferenceRepository.save(springIO);

        // Création des talks
        Talk loomTalk = new Talk(null,
                "Introduction to Project Loom",
                "Découvrez les virtual threads en Java.",
                LocalDateTime.of(2024, 4, 17, 10, 0),
                devoxx,
                null);

        Talk springBootTalk = new Talk(null,
                "Deep Dive into Spring Boot 3",
                "Nouveautés et bonnes pratiques.",
                LocalDateTime.of(2024, 5, 30, 11, 0),
                springIO,
                gavin);

        talkRepository.save(loomTalk);
        talkRepository.save(springBootTalk);

        // Mettre à jour les relations bidirectionnelles si nécessaire
        devoxx.getTalks().add(loomTalk);
        springIO.getTalks().add(springBootTalk);
        conferenceRepository.save(devoxx);
        conferenceRepository.save(springIO);

        gavin.getTalks().add(springBootTalk);
        speakerRepository.save(gavin);

        System.out.println("✅ Données initialisées avec succès !");
    }
}
