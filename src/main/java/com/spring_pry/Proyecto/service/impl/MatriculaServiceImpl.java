package com.spring_pry.Proyecto.service.impl;

import com.spring_pry.Proyecto.model.Estudiante;
import com.spring_pry.Proyecto.model.Matricula;
import com.spring_pry.Proyecto.repo.IEstudianteRepo;
import com.spring_pry.Proyecto.repo.IGenericRepo;
import com.spring_pry.Proyecto.repo.IMatriculaRepo;
import com.spring_pry.Proyecto.service.ICRUD;
import com.spring_pry.Proyecto.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula,Integer> implements IMatriculaService {
    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula,Integer> getRepo(){
        return repo;
    }
}
