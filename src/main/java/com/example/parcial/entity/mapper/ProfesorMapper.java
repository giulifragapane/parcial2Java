package com.example.parcial.entity.mapper;

import com.example.parcial.entity.Profesor;
import com.example.parcial.entity.dto.profesor.ProfesorCreate;
import com.example.parcial.entity.dto.profesor.ProfesorDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper implements BaseMapper<Profesor, ProfesorDTO, ProfesorCreate>{
    @Override
    public Profesor toEntity(ProfesorCreate profesorCreate) {
        Profesor prof = new Profesor();
        prof.setEmail(profesorCreate.email());
        prof.setNombre(profesorCreate.nombre());
        return prof;
    }

    @Override
    public ProfesorDTO toDTO(Profesor profesor) {
        ProfesorDTO profDto = new ProfesorDTO(profesor.getId(), profesor.getNombre(),profesor.getEmail());
        return profDto;
    }
}
