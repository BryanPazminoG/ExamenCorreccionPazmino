package ec.edu.espe.examen.Pazmino.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Pazmino.dao.DocenteMateriaRepository;
import ec.edu.espe.examen.Pazmino.dao.DocenteRepository;
import ec.edu.espe.examen.Pazmino.dao.MateriaRepository;
import ec.edu.espe.examen.Pazmino.domain.Docente;
import ec.edu.espe.examen.Pazmino.domain.DocenteMateria;
import ec.edu.espe.examen.Pazmino.domain.Materia;
import ec.edu.espe.examen.Pazmino.service.Exception.CreacionException;

@Service
public class PlanificacionService {
    private final DocenteRepository docenteRepository;
    private final MateriaRepository materiaRepository;
    private final DocenteMateriaRepository docenteMateriaRepository;

    public PlanificacionService(DocenteRepository docenteRepository, MateriaRepository materiaRepository, DocenteMateriaRepository docenteMateriaRepository) {
        this.docenteRepository = docenteRepository;
        this.materiaRepository = materiaRepository;
        this.docenteMateriaRepository = docenteMateriaRepository;
    }

    public DocenteMateria crearDocenteMateria(DocenteMateria docenteMateria) {
        try {
            Optional<Docente> docente = docenteRepository.findById(docenteMateria.getPK().getCodigoDocente());
            Optional<Materia> materia = materiaRepository.findById(docenteMateria.getPK().getCodigoMateria());

            if (docente.isPresent() && materia.isPresent()) {
                return this.docenteMateriaRepository.save(docenteMateria);
            } else {
                throw new RuntimeException("El Docente: " + docenteMateria.getPK().getCodigoDocente() + " o Materia "
                        + docenteMateria.getPK().getCodigoMateria() + "son invalidos: ");
            }
        } catch (Exception e) {
            throw new CreacionException("Ocurrio un error al crear docente-materia: " + docenteMateria.toString(), e);
        }
    }



    
}
