package com.crudOperation.main.services;

import com.crudOperation.main.entity.EmployeeDAO;
import com.crudOperation.main.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmpServiceEmpl implements EmployeService{

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmpServiceEmpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDAO> getEntityList() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDAO getEntityById(Long id) {
        return employeeRepository.getReferenceById(id);
    }

    @Override
    public void deleteEntity(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDAO createEntity(EmployeeDAO employeeDAO) {
        return employeeRepository.save(employeeDAO);
    }

    @Override
    public EmployeeDAO updateEntity(Long id, EmployeeDAO employeeDAO) {
        Optional<EmployeeDAO> isEmployee = employeeRepository.findById(id);
        if (isEmployee.isPresent()) {
            EmployeeDAO emppDao = isEmployee.get();
            emppDao.setEmpName(employeeDAO.getEmpName());
            emppDao.setSalary(employeeDAO.getSalary());
            emppDao.setAddress(employeeDAO.getAddress());
            emppDao.setJobProfile(employeeDAO.getJob_profile());
            return employeeRepository.save(emppDao);
        } else{
            throw new RuntimeException("Employee not found");
        }
    }
}
