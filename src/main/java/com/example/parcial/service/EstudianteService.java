package com.example.parcial.service;

import com.example.parcial.entity.Curso;
import com.example.parcial.entity.Estudiante;
import com.example.parcial.entity.dto.curso.CursoDTO;
import com.example.parcial.entity.dto.curso.CursoEdit;
import com.example.parcial.entity.dto.estudiante.EstudianteCreate;
import com.example.parcial.entity.dto.estudiante.EstudianteDTO;
import com.example.parcial.entity.dto.estudiante.EstudianteEdit;

import java.util.List;

public interface EstudianteService extends BaseService<EstudianteDTO, EstudianteCreate, EstudianteEdit, Long> {
    void addCurso(Curso curso, Estudiante e); //Permite agregar un curso a un estudiante
    List<CursoDTO> findCursosById(Long studianteId);
    EstudianteDTO update(Long estudianteId, EstudianteEdit estudianteEdit);
}
