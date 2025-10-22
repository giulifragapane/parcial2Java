package com.example.parcial.entity.mapper;

import com.example.parcial.entity.Estudiante;
import com.example.parcial.entity.dto.estudiante.EstudianteCreate;
import com.example.parcial.entity.dto.estudiante.EstudianteDTO;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper implements BaseMapper<Estudiante, EstudianteDTO, EstudianteCreate>{
    @Override
    public Estudiante toEntity(EstudianteCreate estudianteCreate) {
        Estudiante est = new Estudiante();
        est.setNombre(estudianteCreate.nombre());
        est.setMatricula(estudianteCreate.matricula());
        return est;
    }

    @Override
    public EstudianteDTO toDTO(Estudiante estudiante) {
        return new EstudianteDTO(estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getMatricula());
    }
}
