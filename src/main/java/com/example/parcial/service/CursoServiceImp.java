package com.example.parcial.service;

import com.example.parcial.entity.Curso;
import com.example.parcial.entity.dto.curso.CursoCreate;
import com.example.parcial.entity.dto.curso.CursoDTO;
import com.example.parcial.entity.dto.curso.CursoEdit;
import com.example.parcial.repository.CursoRepository;
import com.example.parcial.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImp extends BaseServiceImp<Curso, CursoDTO, CursoCreate, CursoEdit, Long> implements CursoService{

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void addEstudiante(Long cursoId, Long estudianteId) {
        var e = estudianteRepository.getById(estudianteId); //Obtenemos un estudiante desde su repositorio por su ID
        var c = cursoRepository.getById(cursoId); //Obtenemos un curso desde su repositorio por su ID
        c.getEstudiantes().add(e); //Agregamos el estudiante al curso
        cursoRepository.save(c); //Guardamos el curso en la BD
        e.getCursos().add(c); //Agregamos el curso al estudiante
        estudianteRepository.save(e); //Guardamos el estudiante en la BD
    }

    @Override
    public CursoDTO update(Long cursoId, CursoEdit cursoEdit) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso NO encontrado"));

        curso.setNombre(cursoEdit.nombre()); //Actualizamos el nombre

        cursoRepository.save(curso); //Guardamos el curso en la BD
        return baseMapper.toDTO(curso);
    }

}
