package ec.edu.espe.examen.Pazmino.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.Pazmino.domain.DocenteMateria;
import ec.edu.espe.examen.Pazmino.service.PlanificacionService;

@RestController
@RequestMapping("/planificacion")
public class PlanificacionController {

    private final PlanificacionService planificacionService;

    public PlanificacionController(PlanificacionService planificacionService) {
        this.planificacionService = planificacionService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<DocenteMateria> GuardarProfesorMateria(@RequestBody DocenteMateria docenteMateria){
        return new ResponseEntity<>(planificacionService.crearDocenteMateria(docenteMateria), HttpStatus.OK);
    }
    
}
