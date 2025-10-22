package com.example.parcial.repository;

import com.example.parcial.entity.Curso;
import com.example.parcial.entity.Estudiante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends BaseRepository<Estudiante, Long> {

    //Selecciona los cursos de un estudiante por su ID
    @Query("SELECT e.cursos FROM Estudiante e WHERE e.id = :id AND e.eliminado = false")
    List<Curso> findCursosById(Long id);
}
