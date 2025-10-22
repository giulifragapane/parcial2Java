package com.example.parcial.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder //Las demás clases heredan de Base
@MappedSuperclass //Indica que no es una entidad en sí pero sus atributos si se heredan a las entidades hijas
public class Base {
    //Atributos comunes a todas las entidades
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID Auto incremental
    private Long id;

    @Builder.Default //Indica que el atributo se inicializara con el valor por defecto
    private Boolean eliminado = false; //Para implementar el borrado lógico
}
