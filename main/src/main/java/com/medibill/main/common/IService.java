package com.medibill.main.common;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public class IService <T, R extends JpaRepository<T, Long>>{
    protected R repository;
    public IService(R repository){
        this.repository = repository;
    }
    public List<T> getList(){
        return repository.findAll();
    }
    public Optional<T> getEntityById(Long id){
        return  repository.findById(id);
    }

    public T createEntity(T entity){
        return repository.save(entity);
    }

    public T updateEntity(Long id, T entity){
        if (repository.existsById(id)){
            return repository.save(entity);
        }
        return null;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
