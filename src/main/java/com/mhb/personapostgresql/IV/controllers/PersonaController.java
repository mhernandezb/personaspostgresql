package com.mhb.personapostgresql.IV.controllers;

import com.mhb.personapostgresql.IV.entities.Persona;
import com.mhb.personapostgresql.IV.services.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;
@RestController
@Slf4j
public class PersonaController {
    private PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }


    @PostMapping("/personal")
    public RedirectView crearPersona(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Persona persona, Model model) {
        model.addAttribute(persona);
        this.service.crearPersona(persona);
        return new RedirectView("/personal");
    }


    @GetMapping("/personal/eliminar/{id}")
    public RedirectView borrarPersona(@PathVariable("id") Long id) {
        this.service.borrarPesona(id);
        return new RedirectView("/personal");
    }

}
