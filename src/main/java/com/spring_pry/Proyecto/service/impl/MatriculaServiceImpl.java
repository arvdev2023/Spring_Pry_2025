package com.spring_pry.Proyecto.service.impl;

import com.spring_pry.Proyecto.model.DetalleMatricula;
import com.spring_pry.Proyecto.model.Estudiante;
import com.spring_pry.Proyecto.model.Matricula;
import com.spring_pry.Proyecto.repo.IEstudianteRepo;
import com.spring_pry.Proyecto.repo.IGenericRepo;
import com.spring_pry.Proyecto.repo.IMatriculaRepo;
import com.spring_pry.Proyecto.service.ICRUD;
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
        //Map map=null;
        List listDetalle=new ArrayList();
        Stream<Matricula> matriculaStream=repo.findAll().stream();
        //Stream<List<DetalleMatricula>> detalleMatriculaStream=matriculaStream.map(Matricula::getDetalleMatriculaList);
        //List listDetalle=detalleMatriculaStream.toList();
        //List listDetalle = detalleMatriculaStream.flatMap(Collection::stream).toList();

         //matriculaStream.flatMap(matricula -> matricula.getDetalleMatriculaList().stream())
                //.map(detalleMatricula -> detalleMatricula.getCurso().getNombre()).forEach(System.out::println);
                Map<String,List<String>> map=matriculaStream.flatMap(matricula -> matricula.getDetalleMatriculaList().stream()
                .map(d -> new AbstractMap.SimpleEntry<>(
                        d.getCurso().getNombre(),
                        matricula.getEstudiante().getNombres() + " " + matricula.getEstudiante().getApellidos()
                ))
        )
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
        return map;
    }
}
