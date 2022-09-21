package com.mhb.personapostgresql.IV.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persona")
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "genero")
    private String genero;
    @Column(name = "email")
    private String email;

    @Column(name = "fecha")
    private LocalDate fecha;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String genero, String email, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.email = email;
        this.fecha = fecha;
    }
}
