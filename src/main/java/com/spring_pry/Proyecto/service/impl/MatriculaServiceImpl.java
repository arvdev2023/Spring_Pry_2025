package com.spring_pry.Proyecto.service.impl;


import com.spring_pry.Proyecto.model.Matricula;
import com.spring_pry.Proyecto.repo.IGenericRepo;
import com.spring_pry.Proyecto.repo.IMatriculaRepo;
import com.spring_pry.Proyecto.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula,Integer> implements IMatriculaService {
    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula,Integer> getRepo(){
        return repo;
    }

    public Map<String,List<String>> getSubjectByEstudiante(){

        Stream<Matricula> matriculaStream=repo.findAll().stream();
                Map<String,List<String>> map=matriculaStream.flatMap(matricula -> matricula.getDetalleMatriculaList().stream()
                .map(d -> new AbstractMap.SimpleEntry<>(
                        d.getCurso().getNombre(),
                        matricula.getEstudiante().getNombres() + " " + matricula.getEstudiante().getApellidos()
                ))).collect(Collectors.groupingBy(
                    Map.Entry::getKey,
                    Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
        return map;
    }
}
