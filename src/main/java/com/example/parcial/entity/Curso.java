package com.example.parcial.entity;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity //Indica que es una entidad; que esta clase si representa una tabla en la BD
public class Curso extends Base {
    //Extiende de la clase Base herendando los atributos id y eliminado

    //ATRIBUTOS
    private String nombre;

    //RELACIONES
    @ManyToOne //Un profesor puede tener muchos cursos pero cada curso tiene un solo profesor
    private Profesor profesor;

    @ManyToMany
    @JoinTable(name = "estudiante_curso", //Tabla intermedia que une los cursos con los estudiantes
            joinColumns = @JoinColumn(name = "curso_id"), //Columna que referencia a la tabla de cursos
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")) //Columna que referencia a la tabla de estudiantes
    @Builder.Default //Inicializamos el set de estudiantes para que no sea null
    Set<Estudiante> estudiantes = new HashSet<>(); //Set evita duplicados
}
