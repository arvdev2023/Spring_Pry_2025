package com.spring_pry.Proyecto.service.impl;

import com.spring_pry.Proyecto.repo.IGenericRepo;
import com.spring_pry.Proyecto.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();
    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        //VALIDAR POR ID!
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().deleteById(id);
    }
}
