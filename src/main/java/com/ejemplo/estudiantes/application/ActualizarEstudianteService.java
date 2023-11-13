package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActualizarEstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public ActualizarEstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Transactional
    public void actualizarEstudiante(Long estudianteId, Estudiante estudiante) {
        estudianteRepository.findById(estudianteId).ifPresent(estudianteEncontrado -> {
            estudianteEncontrado.setNombre(estudiante.getNombre());
            estudianteEncontrado.setApellido(estudiante.getApellido());
            estudianteEncontrado.setEdad(estudiante.getEdad());
            estudianteRepository.save(estudianteEncontrado);
        });
    }
}
