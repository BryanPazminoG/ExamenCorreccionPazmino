package ec.edu.espe.examen.Pazmino.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ec.edu.espe.examen.Pazmino.domain.Especialidad;
import ec.edu.espe.examen.Pazmino.service.EspecialidadService;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Especialidad> Guardar(@RequestBody Especialidad especialidad) {
        return new ResponseEntity<>(especialidadService.crearEspecialidad(especialidad), HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public List<Especialidad> buscarPorNombre(@RequestParam String patron) {
        return especialidadService.buscarPorPatron(patron);
    }

}
