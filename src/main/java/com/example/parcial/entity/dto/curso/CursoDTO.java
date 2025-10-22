package com.example.parcial.entity.dto.curso;

import com.example.parcial.entity.dto.estudiante.EstudianteDTO;
import com.example.parcial.entity.dto.profesor.ProfesorDTO;

import java.util.List;

public record CursoDTO(
        Long id,
        String nombre,
        ProfesorDTO profesor,
        List<EstudianteDTO> estudiante) { }
