package com.example.parcial.entity.mapper;

import com.example.parcial.entity.Curso;
import com.example.parcial.entity.dto.curso.CursoCreate;
import com.example.parcial.entity.dto.curso.CursoDTO;
import com.example.parcial.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper implements BaseMapper<Curso, CursoDTO, CursoCreate>{

    @Autowired
    private ProfesorMapper profesorMapper;
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private EstudianteMapper estudianteMapper;

    @Override
    public Curso toEntity(CursoCreate cursoCreate) {
        Curso curso = new Curso();
        curso.setNombre(cursoCreate.nombre());
        curso.setProfesor(profesorRepository.getById(cursoCreate.profesorId()));
        return curso;
    }

    @Override
    public CursoDTO toDTO(Curso curso) {
        return new CursoDTO(
                curso.getId(),
                curso.getNombre(),
                profesorMapper.toDTO(curso.getProfesor()),
                curso.getEstudiantes().stream().map(estudianteMapper::toDTO).toList());
    }
}
