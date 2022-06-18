package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.model.Student;
import com.sevinc.intership_management_system.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public Student getByStudentId(Long id){
        return studentRepository.getById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }


}
