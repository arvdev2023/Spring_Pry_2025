package com.spring_pry.Proyecto.controller;

import com.spring_pry.Proyecto.data.RequestWrapper;
import com.spring_pry.Proyecto.data.ResponseWrapper;
import com.spring_pry.Proyecto.dto.EstudianteDTO;
import com.spring_pry.Proyecto.model.Estudiante;
import com.spring_pry.Proyecto.service.IEstudianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proyecto/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {
    private final IEstudianteService service;


    private final ModelMapper modelMapper= new ModelMapper();
    private ResponseWrapper _response;

    @GetMapping("findall")
    public ResponseEntity<ResponseWrapper> findAll() throws Exception{
        _response=new ResponseWrapper();
        List<Estudiante> list= service.findAll();
        _response.setEstudianteList(list);
        return ResponseEntity.ok(_response);
    }
    @GetMapping("listmenores")
    public ResponseEntity<ResponseWrapper> listarMenores() throws Exception{
        _response=new ResponseWrapper();
        List<Estudiante> list= service.listarMenores();
        _response.setEstudianteList(list);
        return ResponseEntity.ok(_response);
    }
    @GetMapping("listbyagedesc")
    public ResponseEntity<ResponseWrapper> listByAgeDesc() throws Exception{
        _response=new ResponseWrapper();
        List<Estudiante> list= service.listByAgeDesc();
        _response.setEstudianteList(list);
        return ResponseEntity.ok(_response);
    }
    @GetMapping("findbyid/{id}")
    public ResponseEntity<ResponseWrapper> findById(@PathVariable Integer id) throws Exception {
        _response=new ResponseWrapper();
        Estudiante obj = service.findById(id);
        _response.setEstudiante(obj);
        return ResponseEntity.ok(_response);
    }
    @PostMapping("create")
    public ResponseEntity<ResponseWrapper> save(@Valid @RequestBody RequestWrapper request) throws Exception{
        _response=new ResponseWrapper();
        Estudiante obj=service.save(_convertToEntity(request.getEstudianteDTO()));
        _response.setEstudiante(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(_response);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<ResponseWrapper> update(@PathVariable Integer id,@Valid @RequestBody RequestWrapper request) throws Exception{
        _response=new ResponseWrapper();
        Estudiante obj=service.update(id,_convertToEntity(request.getEstudianteDTO()));
        _response.setEstudiante(obj);
        return ResponseEntity.ok(_response);
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
