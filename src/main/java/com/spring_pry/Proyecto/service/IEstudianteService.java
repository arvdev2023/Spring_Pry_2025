package com.spring_pry.Proyecto.service;

import com.spring_pry.Proyecto.model.Estudiante;

import java.util.List;

public interface IEstudianteService extends  ICRUD<Estudiante,Integer>{
    List<Estudiante> listarMenores();
    List<Estudiante> listByAgeDesc();
}
