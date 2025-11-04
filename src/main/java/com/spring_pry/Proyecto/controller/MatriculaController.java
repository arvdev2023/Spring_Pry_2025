package com.spring_pry.Proyecto.controller;


import com.spring_pry.Proyecto.data.ResponseWrapper;
import com.spring_pry.Proyecto.model.Estudiante;
import com.spring_pry.Proyecto.model.Matricula;
import com.spring_pry.Proyecto.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("proyecto/matricula")
@RequiredArgsConstructor
public class MatriculaController {
    private final IMatriculaService service;

    private final ModelMapper modelMapper=new ModelMapper();
    private ResponseWrapper _response;

    @GetMapping("findall")
    public ResponseEntity<ResponseWrapper> findAll() throws Exception{
        _response=new ResponseWrapper();
        List<Matricula> list= service.findAll();
        _response.setMatriculaList(list);
        return ResponseEntity.ok(_response);
    }
    @GetMapping("findbyid/{id}")
    public ResponseEntity<ResponseWrapper> findById(@PathVariable Integer id) throws Exception {
        _response=new ResponseWrapper();
        Matricula obj = service.findById(id);
        _response.setMatricula(obj);
        return ResponseEntity.ok(_response);
    }
}
