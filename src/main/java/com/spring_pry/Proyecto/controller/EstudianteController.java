package com.spring_pry.Proyecto.controller;

import com.spring_pry.Proyecto.model.Estudiante;
import com.spring_pry.Proyecto.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("proyecto/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {
    private final IEstudianteService service;

    @GetMapping
    public ResponseEntity<List<Estudiante>> findAll() throws Exception{
        List<Estudiante> list= service.findAll();
        return ResponseEntity.ok(list);
    }
}
