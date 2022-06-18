package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.dto.StudentIdentityResponseDTO;
import com.sevinc.intership_management_system.dto.StudentIdentitySaveDTO;
import com.sevinc.intership_management_system.model.StudentIdentity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentIdentityService {
    StudentIdentityResponseDTO saveStudentIdentity(@RequestBody StudentIdentitySaveDTO studentIdentitySaveDTO);

    List<StudentIdentityResponseDTO> getAllStudentIdentity();

    StudentIdentityResponseDTO getByStudentIdentityResponse(Long studentIdentityId);

    StudentIdentity getByStudentIdentityId(Long studentIdentityId);

    boolean getDeleteStudentIdentity(Long studentIdentityId);
}
