package com.main.studentManagement.service;

import com.main.studentManagement.entity.StudentInfo;
import com.main.studentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository repository;
    @Override
    public List<StudentInfo> getEntityList() {
        return repository.findAll();
    }

    @Override
    public StudentInfo getEntityById(Long id) {
        Optional<StudentInfo> getEntity = repository.findById(id);
        return getEntity.orElseThrow();
    }

    @Override
    public StudentInfo createEntity(StudentInfo student) {
        return repository.save(student);
    }

    @Override
    public void deleteEntity(Long id, StudentInfo student) throws NoSuchMethodException {
        throw new NoSuchMethodException("Not allowed to delete");
    }
}
