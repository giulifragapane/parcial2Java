package com.example.parcial.service;

import java.util.List;

public interface BaseService <D, DC, DE, ID> {
    //D = DTO de salida
    //DC = DTO de creación
    //ID = ID de la entidad

    //MÉTODOS DE LA INTERFAZ
    //Define las operaciones CRUD básicas que todos los servicios van a tener:
    //Permite crear una entidad
    public D create(DC dc);
    //Devuelve una lista de todas las entidades que no han sido eliminadas
    public List<D> findAll();
    //Devuelve los datos de una entidad por su ID
    public D findById(ID id);
    //Elimina una entidad por su ID (borrado lógico)
    public void deleteById(ID id);
}
