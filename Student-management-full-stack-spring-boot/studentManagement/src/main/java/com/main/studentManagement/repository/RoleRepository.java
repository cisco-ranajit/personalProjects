package com.main.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.main.studentManagement.entity.Role;
public interface RoleRepository extends JpaRepository<Role,String>{
}
