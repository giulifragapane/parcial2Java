package com.example.parcial.controller;

import com.example.parcial.entity.dto.profesor.ProfesorCreate;
import com.example.parcial.entity.dto.profesor.ProfesorDTO;
import com.example.parcial.entity.dto.profesor.ProfesorEdit;
import com.example.parcial.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Indica que es un controlador REST
@CrossOrigin("*")
@RequestMapping("profesor") //Define la URL base
public class ProfesorController extends BaseController<ProfesorDTO, ProfesorCreate, ProfesorEdit, Long>{

    @Autowired
    private ProfesorService profesorService;

    // Buscando un profesor por email
    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        try {
            ProfesorDTO profesor = profesorService.findByEmail(email);
            if (profesor == null) {
                return ResponseEntity.badRequest().body("No se encontró ningún profesor con ese email");
            }
            return ResponseEntity.ok(profesor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("UPS...Ocurrió un error: " + e.getMessage());
        }
    }

    // PUT /profesor/{id} - Actualizamos los datos del profesor
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProfesorEdit profesorEdit) {
        try {
            return ResponseEntity.ok(profesorService.update(id, profesorEdit));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("UPS...Ocurrió un error: " + e.getMessage());
        }
    }
}
