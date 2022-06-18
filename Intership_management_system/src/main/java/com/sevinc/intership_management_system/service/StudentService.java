package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.model.Student;

import java.util.List;

public interface StudentService {
    Student getByStudentId(Long id);
    List<Student> getAll();
}
