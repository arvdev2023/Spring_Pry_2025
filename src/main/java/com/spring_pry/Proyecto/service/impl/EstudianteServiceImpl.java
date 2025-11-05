package com.spring_pry.Proyecto.service.impl;

import com.spring_pry.Proyecto.model.Estudiante;
import com.spring_pry.Proyecto.repo.IEstudianteRepo;
import com.spring_pry.Proyecto.repo.IGenericRepo;
import com.spring_pry.Proyecto.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante,Integer> implements IEstudianteService {
    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante,Integer> getRepo(){
        return repo;
    }

    public List<Estudiante> listarMenores(){
        return repo.findAll().stream().filter(estudiante -> estudiante.getEdad()<=24).collect(Collectors.toList());
    }

    public List<Estudiante> listByAgeDesc(){
        return repo.findAll().stream().sorted(Comparator.comparing(Estudiante::getEdad).reversed()).collect(Collectors.toList());
    }
}
