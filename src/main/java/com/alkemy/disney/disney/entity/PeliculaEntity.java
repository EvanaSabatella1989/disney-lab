package com.alkemy.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.crossstore.HashMapChangeSet;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

@Entity
@Table(name = "pelicula")
@Getter
@Setter
public class PeliculaEntity {
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyy/MM/dd")
    private LocalDate fechaCreacion;



    private Long calificacion; //del 1 al 5

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pelicula_id", insertable = false, updatable = false)
    private GeneroEntity genero;

    @Column(name = "genero_id", nullable = false)
    private Long generoId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<PeliculaEntity> personajes = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final PeliculaEntity other = (PeliculaEntity) obj;
        return other.id == this.id;
    }
}





