package com.example.parcial.repository;

import com.example.parcial.entity.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean //Le dice a Spring Data JPA que NO debe crear una instancia
 //(un bean) de esta interfaz en el contexto de Spring
public interface BaseRepository<E extends Base, ID> extends JpaRepository<E, ID> {
    //E representa el tipo de entidad (Estudiante, Profesor, Curso)
    //I representa el tipo de identificador
    //"extends JpaRepository<E, I>" indica que la interfaz hereda todos los
    // métodos CRUD de JpaRepository (findAll(), findById(), save(), deleteById(), etc.)

    //El metodo "findByEliminadoFalse" devuelve una lista de entidades que no han sido eliminadas
    List<E> findByEliminadoFalse();

    //El metodo "findByEliminadoTrue" devuelve una lista de entidades que han sido eliminadas
    //List<E> findByEliminadoTrue();

    //El metodo "findAll" devuelve una lista de entidades que no han sido eliminadas
    public default List<E> findAll() {
        return findByEliminadoFalse();
    }

    //El metodo "deleteById" elimina una entidad por su ID
    public default void deleteById(ID id){
        E e = getById(id);
        e.setEliminado(true);
        save(e);
    }

    //Busca una entidad por su id y si esta eliminada la devuelve; devuelve un Optional
    // que puede estar vacío si la entidad no se encuentra
    public Optional<E> findByIdAndEliminadoFalse(ID id);

    //Llama al metodo anterior y si no encuentra la entidad
    // (porque no existe o está eliminada), lanza una excepción.
    public default E getById(ID id){
        return findByIdAndEliminadoFalse(id)
                .orElseThrow(() -> new NullPointerException("No se encuentra la entidad con id:" + id));

    }
}
