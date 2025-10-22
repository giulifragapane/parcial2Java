package com.example.parcial.controller;

import com.example.parcial.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<D, DC, DE, ID> {

    @Autowired
    BaseService<D, DC, DE,ID> baseService; //Tiene los metodos create, findById, findAll, deleteById

    @PostMapping //Expone la ruta POST
    public ResponseEntity<?> create (@RequestBody DC dc){ //Recibe un DTO de creación desde el body de la petición
        try{
            return ResponseEntity.ok(baseService.create(dc)); //llama al servicio para crear la entidad
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("UPS...Ocurrió un error: " + e.getMessage());
        }
    }
    @GetMapping("{id}") //Expone GET
    public ResponseEntity<?> findById (@PathVariable ID id){ //Obtiene el id de la URL
        try{
            return ResponseEntity.ok(baseService.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("UPS...Ocurrió un error: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll (){
        try{
            return ResponseEntity.ok(baseService.findAll()); //Devuelve una lista de todos los elementos
        }catch (Exception e){
            return ResponseEntity.badRequest().body("UPS...Ocurrió un error: "  + e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete (@PathVariable ID id){
        try{
            baseService.deleteById(id); // Llama al servicio para eliminar la entidad (borrado lógico)
            return ResponseEntity.ok("Se eliminó exitosamente la entidad con id: " + id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("UPS...Ocurrió un error: " +  e.getMessage());
        }
    }

}
