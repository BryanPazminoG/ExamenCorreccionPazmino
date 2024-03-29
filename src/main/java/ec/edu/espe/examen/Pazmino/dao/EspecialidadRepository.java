package ec.edu.espe.examen.Pazmino.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examen.Pazmino.domain.Especialidad;

public interface EspecialidadRepository extends CrudRepository<Especialidad, Integer>{

    public List<Especialidad> findByNombreContaining(String nombre);
    Optional<Especialidad> findByCodigo(String codigo);

}
