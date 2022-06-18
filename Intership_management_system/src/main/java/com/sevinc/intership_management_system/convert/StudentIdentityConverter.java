package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.StudentIdentityResponseDTO;
import com.sevinc.intership_management_system.dto.StudentIdentitySaveDTO;
import com.sevinc.intership_management_system.model.StudentIdentity;
import com.sevinc.intership_management_system.util.DateFormatUtils;
import org.springframework.stereotype.Component;

@Component
public class StudentIdentityConverter {

    public StudentIdentity convertStudentIdentity(StudentIdentitySaveDTO studentIdentitySaveDTO){
        StudentIdentity studentIdentity = new StudentIdentity();

        studentIdentity.setBirthDate(DateFormatUtils.formatBirthdate(studentIdentitySaveDTO.getBirthDate()));
        studentIdentity.setBirthPlace(studentIdentitySaveDTO.getBirthPlace());
        studentIdentity.setFatherName(studentIdentitySaveDTO.getFatherName());
        studentIdentity.setMotherName(studentIdentitySaveDTO.getMotherName());
        studentIdentity.setHealthCovergeEnum(studentIdentitySaveDTO.getHealthCovergeEnum());

        return studentIdentity;
    }

    public StudentIdentityResponseDTO convertStudentIdentityResponse(StudentIdentity studentIdentity){
        StudentIdentityResponseDTO studentIdentityResponseDTO = new StudentIdentityResponseDTO();

        studentIdentityResponseDTO.setStudentIdentityId(studentIdentity.getStudentIdentityId());
        studentIdentityResponseDTO.setBirthDate(DateFormatUtils.formatDate(studentIdentity.getBirthDate(),DateFormatUtils.DATE));
        studentIdentityResponseDTO.setBirthPlace(studentIdentity.getBirthPlace());
        studentIdentityResponseDTO.setFatherName(studentIdentity.getFatherName());
        studentIdentityResponseDTO.setMotherName(studentIdentity.getMotherName());
        studentIdentityResponseDTO.setHealthCovergeEnum(studentIdentity.getHealthCovergeEnum());

        return studentIdentityResponseDTO;
    }

}
