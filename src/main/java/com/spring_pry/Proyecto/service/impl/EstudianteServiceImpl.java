package com.spring_pry.Proyecto.service.impl;

import com.spring_pry.Proyecto.model.Estudiante;
import com.spring_pry.Proyecto.repo.IEstudianteRepo;
import com.spring_pry.Proyecto.repo.IGenericRepo;
import com.spring_pry.Proyecto.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante,Integer> implements IEstudianteService {
    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante,Integer> getRepo(){
        return repo;
    }
}
