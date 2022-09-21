package com.mhb.personapostgresql.IV.services;

import com.mhb.personapostgresql.IV.entities.Persona;
import com.mhb.personapostgresql.IV.repositories.PersonaRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    private PersonaRespository repository;

    public PersonaService(PersonaRespository repository) {
        this.repository = repository;
    }

    public List<Persona> getListaPersonas() {
        return this.repository.findAll();
    }

    public Persona crearPersona(Persona unaPersona) {
        return this.repository.save(unaPersona);
    }

    public Boolean actualizarPesona(Long id) {
        Optional<Persona> persona = this.repository.findById(id);
        this.repository.findById(id);
        return true;
    }

    public Boolean borrarPesona(Long id) {
        this.repository.deleteById(id);
        return true;
    }
}
