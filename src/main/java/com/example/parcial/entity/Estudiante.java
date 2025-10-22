package com.example.parcial.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity //Indica que es una entidad; que esta clase si representa una tabla en la BD
public class Estudiante extends Base {
    //Extiende de la clase Base herendando los atributos id y eliminado

    //ATRIBUTOS
    private String nombre;
    private String matricula;

    //RELACIONES
    @ManyToMany(mappedBy = "estudiantes") //Relacion muchos a muchos
    //Con mappedBy indicamos que no cree otra tabla intermedia, que
    // se use la que está definida en la clase Curso en el atributo estudiantes
    @Builder.Default
    Set<Curso> cursos = new HashSet<>(); //Set evita duplicados
}
