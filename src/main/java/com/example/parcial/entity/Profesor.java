package com.example.parcial.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity //Indica que es una entidad; que esta clase si representa una tabla en la BD
public class Profesor extends Base {
    //Extiende de la clase Base herendando los atributos id y eliminado

    //ATRIBUTOS
    private String nombre;
    private String email;
}
