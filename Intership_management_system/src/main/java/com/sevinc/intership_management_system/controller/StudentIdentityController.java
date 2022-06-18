package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.dto.StudentIdentityResponseDTO;
import com.sevinc.intership_management_system.dto.StudentIdentitySaveDTO;
import com.sevinc.intership_management_system.service.StudentIdentityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student-identity")
@RequiredArgsConstructor
@CrossOrigin
public class StudentIdentityController {

    private final StudentIdentityService studentIdentityService;

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("save")
    public StudentIdentityResponseDTO saveStudentIdentity(@RequestBody StudentIdentitySaveDTO studentIdentitySaveDTO) {
        return studentIdentityService.saveStudentIdentity(studentIdentitySaveDTO);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("all")
    public List<StudentIdentityResponseDTO> studentIdentityeAll() {
        return studentIdentityService.getAllStudentIdentity();
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("{id}")
    public StudentIdentityResponseDTO getByStudentIdentityId(@PathVariable("id") Long id) {
        return studentIdentityService.getByStudentIdentityResponse(id);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @DeleteMapping("delete/{id}")
    public boolean studentIdentityDelete(@PathVariable("id") Long id){
        return studentIdentityService.getDeleteStudentIdentity(id);
    }


}
