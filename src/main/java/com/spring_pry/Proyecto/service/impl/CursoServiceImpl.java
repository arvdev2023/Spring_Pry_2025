package com.spring_pry.Proyecto.service.impl;

import com.spring_pry.Proyecto.model.Curso;
import com.spring_pry.Proyecto.model.Estudiante;
import com.spring_pry.Proyecto.repo.ICursoRepo;
import com.spring_pry.Proyecto.repo.IGenericRepo;
import com.spring_pry.Proyecto.service.ICursoService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CRUDImpl<Curso,Integer> implements ICursoService {
    private final ICursoRepo repo;
    @Override
    protected IGenericRepo<Curso,Integer> getRepo(){
        return repo;
    }
}
