package com.example.parcial.service;

import com.example.parcial.entity.Base;
import com.example.parcial.entity.mapper.BaseMapper;
import com.example.parcial.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseServiceImp<E extends Base, D, DC, DE, ID> implements BaseService<D, DC, DE, ID> {
    //Implementa la interfaz BaseService para realizar operaciones CRUD de forma genérica, sin repetir código

    @Autowired
    BaseRepository<E, ID> baseRepository; //Para acceder a la BD

    @Autowired
    BaseMapper<E, D, DC> baseMapper; //Para convertir entre entidades y DTOs

    @Override
    public D create(DC dc) {
        E e = baseMapper.toEntity(dc); //Convierte DTO de entrada a entidad
        baseRepository.save(e); //Guarda la entidad en la BD
        return baseMapper.toDTO(e); //Convierte entidad guardada a DTO
    }

    @Override
    public List<D> findAll() {
        return baseRepository.findAll() //Obtiene todas las entidades no eliminadas
                .stream()
                .map(baseMapper::toDTO) //Convierte cada entidad a DTOConvierte cada entidad a DTO
                .toList(); //Devuelve la lista de DTOs
    }

    @Override
    public D findById(ID id) {
        return baseMapper.toDTO(baseRepository.getById(id)); //Obtiene la entidad por su ID
        //Convierte a DTO de salida
        //Lanza excepción si no se encuentra la entidad
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id); //Marca eliminado = true
    }
}
