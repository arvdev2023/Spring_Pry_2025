package com.spring_pry.Proyecto.service;

import com.spring_pry.Proyecto.model.Matricula;

import java.util.List;
import java.util.Map;

public interface IMatriculaService extends ICRUD<Matricula,Integer>{
    Map<String,List<String>> getSubjectByEstudiante();
}
