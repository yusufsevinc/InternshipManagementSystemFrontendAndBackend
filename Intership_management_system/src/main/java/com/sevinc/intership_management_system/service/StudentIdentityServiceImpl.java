package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.convert.StudentIdentityConverter;
import com.sevinc.intership_management_system.dto.StudentIdentityResponseDTO;
import com.sevinc.intership_management_system.dto.StudentIdentitySaveDTO;
import com.sevinc.intership_management_system.exceptions.ServiceRuntimeException;
import com.sevinc.intership_management_system.model.StudentIdentity;
import com.sevinc.intership_management_system.repository.StudentIdentityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentIdentityServiceImpl implements StudentIdentityService {

    private final StudentIdentityRepository studentIdentityRepository;
    private final StudentIdentityConverter studentIdentityConverter;


    @Override
    @Transactional
    public StudentIdentityResponseDTO saveStudentIdentity(@RequestBody StudentIdentitySaveDTO studentIdentitySaveDTO) {
        StudentIdentity studentIdentity = studentIdentityConverter.convertStudentIdentity(studentIdentitySaveDTO);
        studentIdentity = studentIdentityRepository.save(studentIdentity);
        return studentIdentityConverter.convertStudentIdentityResponse(studentIdentity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentIdentityResponseDTO> getAllStudentIdentity() {
        List<StudentIdentity> studentIdentityList = studentIdentityRepository.findAll();
        return studentIdentityList.stream()
                .map(studentIdentity -> studentIdentityConverter.convertStudentIdentityResponse(studentIdentity))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public StudentIdentityResponseDTO getByStudentIdentityResponse(Long studentIdentityId) {
        final var studentIdentity = studentIdentityRepository.findById(studentIdentityId)
                .orElseThrow(() -> new ServiceRuntimeException("StudentIdentity Not Found"));
        StudentIdentityResponseDTO studentIdentityResponseDto = studentIdentityConverter.convertStudentIdentityResponse(studentIdentity);
        return studentIdentityResponseDto;
    }

    @Override
    @Transactional(readOnly = true)
    public StudentIdentity getByStudentIdentityId(Long studentIdentityId) {
        final var studentIdentity = studentIdentityRepository.findById(studentIdentityId)
                .orElseThrow(() -> new ServiceRuntimeException("StudentIdentity Not Found"));
        return studentIdentity;
    }

    @Override
    @Transactional
    public boolean getDeleteStudentIdentity(Long studentIdentityId) {
        StudentIdentity studentIdentity = getByStudentIdentityId(studentIdentityId);
        if (studentIdentity.getStudentIdentityId() == studentIdentityId) {
            studentIdentityRepository.deleteStudentIdentityByStudentIdentityId(studentIdentityId);
            return true;
        } else {
            return false;
        }
    }

}
