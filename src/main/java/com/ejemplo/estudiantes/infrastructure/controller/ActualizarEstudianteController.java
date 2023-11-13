package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.ActualizarEstudianteService;
import com.ejemplo.estudiantes.domain.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("estudiantes")
public class ActualizarEstudianteController {

    private final ActualizarEstudianteService actualizarEstudianteService;

    @Autowired
    public ActualizarEstudianteController(ActualizarEstudianteService actualizarEstudianteService) {
        this.actualizarEstudianteService = actualizarEstudianteService;
    }

    @PutMapping("{id}")
    public void actualizarEstudiante(Long estudianteId, Estudiante estudiante) {
        log.info("Se va actualizar un estudiante");
        actualizarEstudianteService.actualizarEstudiante(estudianteId, estudiante);
    }
}
