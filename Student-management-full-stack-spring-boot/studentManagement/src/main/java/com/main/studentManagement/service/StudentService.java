package com.main.studentManagement.service;

import com.main.studentManagement.entity.StudentInfo;

import java.util.List;

public interface StudentService {
    List<StudentInfo> getEntityList();
    StudentInfo getEntityById(Long id);
    StudentInfo createEntity(StudentInfo student);
    void deleteEntity(Long id, StudentInfo student) throws NoSuchMethodException;
}
