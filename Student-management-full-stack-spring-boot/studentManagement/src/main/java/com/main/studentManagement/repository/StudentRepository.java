package com.main.studentManagement.repository;

import com.main.studentManagement.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentInfo, Long> {
}