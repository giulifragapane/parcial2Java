package com.example.parcial.controller;


import com.example.parcial.entity.dto.curso.CursoCreate;
import com.example.parcial.entity.dto.curso.CursoDTO;
import com.example.parcial.entity.dto.curso.CursoEdit;
import com.example.parcial.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Indica que es un controlador REST
@CrossOrigin("*")
@RequestMapping("curso") //Define la URL base
public class CursoController extends BaseController<CursoDTO, CursoCreate, CursoEdit, Long>{

    @Autowired
    CursoService cursoService;

    // /curso/addEstudiante/{idCurso}/{idEstudiante} - agrega un estudiante a un curso
    @PutMapping("addEstudiante/{cursoId}/{estudianteId}")
    public ResponseEntity<?> addEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId){ //PathVariable indica que los valores vienen en la URL
        try{
            cursoService.addEstudiante(cursoId,estudianteId); //Llamamos al servicio para que haga la operación
            return ResponseEntity.ok("Se agregó al estudiante con éxito");

        }catch (Exception e ){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("UPS...Ocurrió un error " + e.getMessage());
        }
    }

    // /curso/{id}
    @PutMapping("{id}") //Actualizamos un curso existente
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CursoEdit cursoEdit) {
        try {
            return ResponseEntity.ok(cursoService.update(id, cursoEdit));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("UPS...Ocurrió un error: " + e.getMessage());
        }
    }
}
