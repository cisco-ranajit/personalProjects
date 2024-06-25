package com.crudOperation.main.services;

import com.crudOperation.main.entity.EmployeeDAO;

import java.util.List;

public interface EmployeService {
    List<EmployeeDAO> getEntityList();
    EmployeeDAO getEntityById(Long id);
    void deleteEntity(Long id);
}
