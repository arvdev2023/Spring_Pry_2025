package com.spring_pry.Proyecto.controller;

import com.spring_pry.Proyecto.dto.EstudianteDTO;
import com.spring_pry.Proyecto.model.Estudiante;
import com.spring_pry.Proyecto.service.IEstudianteService;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proyecto/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {
    private final IEstudianteService service;


    private final ModelMapper modelMapper= new ModelMapper();

    @GetMapping
    public ResponseEntity<List<Estudiante>> findAll() throws Exception{
        List<Estudiante> list= service.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("findbyid/{id}")
    public ResponseEntity<Estudiante> findById(@PathVariable Integer id) throws Exception {
        Estudiante obj = service.findById(id);

        return ResponseEntity.ok(obj);
    }
    @PostMapping("create")
    public ResponseEntity<Estudiante> save(@RequestBody EstudianteDTO estudianteDto) throws Exception{
        Estudiante obj=service.save(_convertToEntity(estudianteDto));
        return ResponseEntity.ok(obj);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Estudiante> update(@PathVariable Integer id,@RequestBody EstudianteDTO estudianteDTO) throws Exception{
        Estudiante obj=service.update(id,_convertToEntity(estudianteDTO));
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    private Estudiante _convertToEntity(EstudianteDTO estDto){
        return modelMapper.map(estDto,Estudiante.class);
    }
}
