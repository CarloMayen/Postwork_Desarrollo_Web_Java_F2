package org.bedu.java.backend.agenda.persistence;

import org.bedu.java.backend.agenda.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
