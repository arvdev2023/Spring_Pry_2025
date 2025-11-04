package com.spring_pry.Proyecto.controller;

import com.spring_pry.Proyecto.data.RequestWrapper;
import com.spring_pry.Proyecto.data.ResponseWrapper;
import com.spring_pry.Proyecto.dto.CursoDTO;
import com.spring_pry.Proyecto.model.Curso;
import com.spring_pry.Proyecto.model.Estudiante;
import com.spring_pry.Proyecto.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proyecto/cursos")
@RequiredArgsConstructor
public class CursoController {
    private final ICursoService service;

    private final ModelMapper modelMapper= new ModelMapper();
    private ResponseWrapper _response;

    @GetMapping("findall")
    public ResponseEntity<ResponseWrapper> findAll() throws Exception{
        _response=new ResponseWrapper();
        List<Curso> list= service.findAll();
        _response.setCursoList(list);
        return ResponseEntity.ok(_response);
    }
    @GetMapping("findbyid/{id}")
    public ResponseEntity<ResponseWrapper> findById(@PathVariable Integer id) throws Exception {
        _response=new ResponseWrapper();
        Curso obj = service.findById(id);
        _response.setCurso(obj);
        return ResponseEntity.ok(_response);
    }
    @PostMapping("create")
    public ResponseEntity<ResponseWrapper> save(@RequestBody RequestWrapper request) throws Exception{
        _response=new ResponseWrapper();
        Curso obj=service.save(_convertToEntity(request.getCursoDTO()));
        _response.setCurso(obj);
        return ResponseEntity.ok(_response);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<ResponseWrapper> update(@PathVariable Integer id,@RequestBody RequestWrapper request) throws Exception{
        _response=new ResponseWrapper();
        Curso obj=service.update(id,_convertToEntity(request.getCursoDTO()));
        _response.setCurso(obj);
        return ResponseEntity.ok(_response);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    private Curso _convertToEntity(CursoDTO cursoDto){
        return modelMapper.map(cursoDto,Curso.class);
    }
}
