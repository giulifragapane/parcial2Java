package com.example.parcial.repository;

import com.example.parcial.entity.Curso;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends BaseRepository<Curso, Long> {
    //Extiende el BaseRepository y especifica la entidad (Curso) y el tipo de id (Long)
    //Hereda todos los metodos de la clase BaseRepository
}
