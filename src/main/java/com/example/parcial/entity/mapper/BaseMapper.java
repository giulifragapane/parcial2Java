package com.example.parcial.entity.mapper;

public interface BaseMapper<E,D,DC> {
    //Convierte entre entidad (E) y DTO (D y DC)
    //Evita que el Controller o el Service trabajen directamente con entidades de la DB

    //Convierte un DTO en una entidad (E)
    public E toEntity(DC dc);
    //Convierte una entidad (E) en un DTO (D)
    public D toDTO(E e);
}
