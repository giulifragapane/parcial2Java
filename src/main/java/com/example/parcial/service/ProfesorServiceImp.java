package com.example.parcial.service;

import com.example.parcial.entity.Profesor;
import com.example.parcial.entity.dto.estudiante.EstudianteDTO;
import com.example.parcial.entity.dto.profesor.ProfesorCreate;
import com.example.parcial.entity.dto.profesor.ProfesorDTO;
import com.example.parcial.entity.dto.profesor.ProfesorEdit;
import com.example.parcial.entity.mapper.ProfesorMapper;
import com.example.parcial.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImp extends BaseServiceImp<Profesor, ProfesorDTO, ProfesorCreate, ProfesorEdit, Long> implements ProfesorService{

    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    ProfesorMapper profesorMapper;
    @Override
    public ProfesorDTO findByEmail(String email) {
        // Buscar profesor por email usando el repository
        return profesorRepository.findByEmail(email)
                .map(profesorMapper::toDTO) // Convertimos de entidad a DTO
                .orElse(null);           // Devuelve null si no se encuentra
    }

    @Override
    public ProfesorDTO update(Long profesorId, ProfesorEdit profesorEdit) {

        Profesor profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor NO encontrado"));

        profesor.setNombre(profesorEdit.nombre());
        profesor.setEmail(profesorEdit.email());

        baseRepository.save(profesor);

        return profesorMapper.toDTO(profesor);
    }
}
