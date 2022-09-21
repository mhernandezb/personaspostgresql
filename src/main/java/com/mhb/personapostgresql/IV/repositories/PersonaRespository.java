package com.mhb.personapostgresql.IV.repositories;

import com.mhb.personapostgresql.IV.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRespository extends JpaRepository<Persona, Long> {
}
