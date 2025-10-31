package com.spring_pry.Proyecto.service.impl;

import com.spring_pry.Proyecto.repo.IGenericRepo;
import com.spring_pry.Proyecto.service.ICRUD;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();
    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        getRepo().findById(id).orElseThrow(()->new Exception("ID " + id + " no encontrado"));

        String className = t.getClass().getSimpleName();
        String methodName = "setId" + className;
        Method setId = t.getClass().getMethod(methodName, id.getClass());
        setId.invoke(t,id);
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
