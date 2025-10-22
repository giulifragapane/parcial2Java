package com.example.parcial.repository;

import com.example.parcial.entity.Profesor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends BaseRepository<Profesor, Long> {
    //Extiende el BaseRepository y especifica la entidad (Profesor) y el tipo de id (Long)
    //Hereda todos los metodos de la clase BaseRepository

    // Metodo específico para buscar profesor por email
    Optional<Profesor> findByEmail(String email);
}
