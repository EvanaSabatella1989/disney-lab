package com.alkemy.disney.disney.entity;

import java.util.ArrayList;
import ch.qos.logback.core.util.COWArrayList;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;


import javax.persistence.*;
@Entity
@Table(name = "personaje")
@Getter
@Setter
public class PersonajeEntity {
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String nombre;

    private String edad;

    private Long peso;

    private String historia;

    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculas = new ArrayList<>();

    //Add and remove peliculas
    public void addPais(PeliculaEntity pelicula) {this.peliculas.add(pelicula);}

    public void removePais(PeliculaEntity pelicula) {this.peliculas.remove(pelicula);}
}





