package com.example.parcial.service;

import com.example.parcial.entity.Curso;
import com.example.parcial.entity.Estudiante;
import com.example.parcial.entity.dto.curso.CursoDTO;
import com.example.parcial.entity.dto.estudiante.EstudianteCreate;
import com.example.parcial.entity.dto.estudiante.EstudianteDTO;
import com.example.parcial.entity.dto.estudiante.EstudianteEdit;
import com.example.parcial.entity.mapper.CursoMapper;
import com.example.parcial.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteServiceImp extends BaseServiceImp<Estudiante, EstudianteDTO, EstudianteCreate, EstudianteEdit,Long> implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    CursoMapper cursoMapper;

    @Override
    public void addCurso(Curso curso, Estudiante e) {
        // Agregamos curso a la lista de cursos del estudiante
        e.getCursos().add(curso);
        // Guardamos los cambios en la BD
        baseRepository.save(e);
    }

    @Override
    public List<CursoDTO> findCursosById(Long estudianteId) {
        return estudianteRepository.findCursosById(estudianteId).stream()
                .map(cursoMapper::toDTO)
                .toList();
    }

    @Override
    public EstudianteDTO update(Long estudianteId, EstudianteEdit estudianteEdit) {
        // Buscamos la entidad por ID
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante NO encontrado"));

        // Actualizo los campos editables usando el record
        estudiante.setNombre(estudianteEdit.nombre());
        estudiante.setMatricula(estudianteEdit.matricula());

        // Guardo los cambios en la BD
        baseRepository.save(estudiante);

        // Convertir a DTO y devolver
        return baseMapper.toDTO(estudiante);
    }

}
