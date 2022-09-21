package com.mhb.personapostgresql.IV.controllers;

import com.mhb.personapostgresql.IV.entities.Persona;
import com.mhb.personapostgresql.IV.entities.User;
import com.mhb.personapostgresql.IV.services.PersonaService;
import com.mhb.personapostgresql.IV.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontControllers {

    private PersonaService service;
    private UserService userService;


    public FrontControllers(PersonaService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        if(principal!=null) {
           User user = this.userService.getOrCreateUser(principal.getClaims());
           model.addAttribute("user",user);
            //System.out.println(principal.getClaims());
        }
        return "index";
    }

    @GetMapping("/personal")
    public String getPersonas(Model model) {
        List<Persona> personas = this.service.getListaPersonas();
        model.addAttribute("personas", personas);
        return "personas";
    }

    @GetMapping("/personal/editar/{id}")
    public String editar(@ModelAttribute Persona persona, Model model) {
        service.actualizarPesona(persona.getId());
        model.addAttribute("persona", persona);
        persona.getNombre();
        persona.getApellido();
        return "agregarPersona";
    }


    @GetMapping("/personal/nueva")
    public String crearPersona(Model model) {
        model.addAttribute("persona", new Persona());
        return "agregarpersona";
    }
}
