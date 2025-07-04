package fr.formation.conferencemanager.repository;

import fr.formation.conferencemanager.entity.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Long> {
}
