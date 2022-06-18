package com.sevinc.intership_management_system.repository;

import com.sevinc.intership_management_system.model.InternshipDocument;
import com.sevinc.intership_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InternshipDocumenRepository extends JpaRepository<InternshipDocument , Long> {

     InternshipDocument findByFileTitleEnum(Enum fileTitleEnum);
     InternshipDocument findByFileTitleEnumAndStudentId(Enum fileTitleEnum , Student studentId);

}
