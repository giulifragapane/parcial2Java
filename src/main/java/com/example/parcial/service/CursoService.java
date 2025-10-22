package com.example.parcial.service;

import com.example.parcial.entity.dto.curso.CursoCreate;
import com.example.parcial.entity.dto.curso.CursoDTO;
import com.example.parcial.entity.dto.curso.CursoEdit;

public interface CursoService extends BaseService<CursoDTO, CursoCreate, CursoEdit, Long> {

    //Metodo específico para que relacionemos un curso con un estudiante
    void addEstudiante(Long cursoId, Long estudianteId);
    CursoDTO update(Long cursoId, CursoEdit cursoEdit);

}
