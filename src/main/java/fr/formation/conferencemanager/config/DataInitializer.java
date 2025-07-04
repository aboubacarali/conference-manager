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
import java.util.List;

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
        // ---------- SPEAKERS ----------
        List<Speaker> speakers = List.of(
                new Speaker(null, "James", "Gosling", "Le père de Java.", new ArrayList<>()),
                new Speaker(null, "Gavin", "King", "Créateur de Hibernate.", new ArrayList<>()),
                new Speaker(null, "Josh", "Long", "Évangéliste Spring.", new ArrayList<>()),
                new Speaker(null, "Venkat", "Subramaniam", "Expert Java/Scala/Groovy.", new ArrayList<>()),
                new Speaker(null, "Brian", "Goetz", "Architecte Java Language chez Oracle.", new ArrayList<>())
        );
        speakerRepository.saveAll(speakers);

        // ---------- CONFERENCES ----------
        List<Conference> conferences = List.of(
                new Conference(null, "Devoxx France 2024", LocalDate.of(2024, 4, 17), LocalDate.of(2024, 4, 19), "Paris", new ArrayList<>()),
                new Conference(null, "Spring I/O 2024", LocalDate.of(2024, 5, 30), LocalDate.of(2024, 5, 31), "Barcelone", new ArrayList<>()),
                new Conference(null, "Oracle Code One", LocalDate.of(2024, 6, 10), LocalDate.of(2024, 6, 12), "San Francisco", new ArrayList<>()),
                new Conference(null, "JChampions Conf", LocalDate.of(2024, 7, 5), LocalDate.of(2024, 7, 6), "Online", new ArrayList<>()),
                new Conference(null, "KotlinConf", LocalDate.of(2024, 8, 20), LocalDate.of(2024, 8, 22), "Amsterdam", new ArrayList<>())
        );
        conferenceRepository.saveAll(conferences);

        // ---------- TALKS (pas de speaker assigné) ----------
        List<Talk> talks = List.of(
                new Talk(null, "Introduction to Project Loom", "Découvrez les virtual threads en Java.",
                        LocalDateTime.of(2024, 4, 17, 10, 0), conferences.get(0), null),
                new Talk(null, "Deep Dive into Spring Boot 3", "Nouveautés et bonnes pratiques.",
                        LocalDateTime.of(2024, 5, 30, 11, 0), conferences.get(1), null),
                new Talk(null, "Java Memory Management", "Comprendre le garbage collector moderne.",
                        LocalDateTime.of(2024, 6, 10, 14, 0), conferences.get(2), null),
                new Talk(null, "BDD in Practice", "Behavior Driven Development appliqué.",
                        LocalDateTime.of(2024, 7, 5, 13, 30), conferences.get(3), null),
                new Talk(null, "Coroutines in Kotlin", "Gérer la concurrence efficacement en Kotlin.",
                        LocalDateTime.of(2024, 8, 21, 9, 45), conferences.get(4), null)
        );
        talkRepository.saveAll(talks);

        System.out.println("✅ Données hydratées sans associations (5 speakers, 5 conférences, 5 talks)");
    }
}
