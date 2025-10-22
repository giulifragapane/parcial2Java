package com.example.parcial.controller;

import com.example.parcial.entity.Estudiante;
import com.example.parcial.entity.dto.estudiante.EstudianteCreate;
import com.example.parcial.entity.dto.estudiante.EstudianteDTO;
import com.example.parcial.entity.dto.estudiante.EstudianteEdit;
import com.example.parcial.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Indica que es un controlador REST
@CrossOrigin("*")
@RequestMapping("estudiante") //Define la URL base
public class EstudianteController extends BaseController<EstudianteDTO, EstudianteCreate, EstudianteEdit, Long>{

    @Autowired
    EstudianteService estudianteService;

    @GetMapping("findCursos/{estudianteId}")
    public ResponseEntity<?> findAll (@PathVariable Long estudianteId){
        try{
            return ResponseEntity.ok(estudianteService.findCursosById(estudianteId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("UPS...Ocurrió un error " + e.getMessage());
        }
    }


    // PUT /estudiante/{id} - Actualizamos un estudiante
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EstudianteEdit estudianteEdit) {
        try {
            return ResponseEntity.ok(estudianteService.update(id, estudianteEdit));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("UPS...Ocurrió un error: " + e.getMessage());
        }
    }
}
