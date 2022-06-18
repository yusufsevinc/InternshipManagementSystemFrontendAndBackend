package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.StudentResponseDTO;
import com.sevinc.intership_management_system.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public StudentResponseDTO convertStudentResponse(Student student){
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setFullName(student.getFullName());
        studentResponseDTO.setTelephone(student.getTelephone());
        studentResponseDTO.setSchoolNumber(student.getSchoolNumber());
        return studentResponseDTO;
    }
}
