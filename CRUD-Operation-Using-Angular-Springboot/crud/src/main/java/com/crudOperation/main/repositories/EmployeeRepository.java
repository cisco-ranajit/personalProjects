package com.crudOperation.main.repositories;

import com.crudOperation.main.entity.EmployeeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<EmployeeDAO, Long> {
}
