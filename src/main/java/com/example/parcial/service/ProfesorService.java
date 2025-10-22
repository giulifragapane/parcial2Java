package com.example.parcial.service;

import com.example.parcial.entity.dto.estudiante.EstudianteDTO;
import com.example.parcial.entity.dto.estudiante.EstudianteEdit;
import com.example.parcial.entity.dto.profesor.ProfesorCreate;
import com.example.parcial.entity.dto.profesor.ProfesorDTO;
import com.example.parcial.entity.dto.profesor.ProfesorEdit;

public interface ProfesorService extends BaseService<ProfesorDTO, ProfesorCreate, ProfesorEdit, Long>{
    // Devuelve un profesor por email
    ProfesorDTO findByEmail(String email);
    ProfesorDTO update(Long profesorId, ProfesorEdit profesorEdit);
}
