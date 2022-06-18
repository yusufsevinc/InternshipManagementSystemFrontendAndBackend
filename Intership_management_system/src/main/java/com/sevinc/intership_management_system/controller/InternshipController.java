package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.dto.InternshipDetailResponseDTO;
import com.sevinc.intership_management_system.dto.InternshipResponseDTO;
import com.sevinc.intership_management_system.dto.InternshipSaveDTO;
import com.sevinc.intership_management_system.model.Internship;
import com.sevinc.intership_management_system.model.Student;
import com.sevinc.intership_management_system.repository.InternshipRepository;
import com.sevinc.intership_management_system.service.InternshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("internship")
@RequiredArgsConstructor
@CrossOrigin
public class InternshipController {

    private final InternshipService internshipService;
    private final InternshipRepository internshipRepository;

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("save")
    public InternshipResponseDTO saveInternshipResponse(@RequestBody InternshipSaveDTO internshipSaveDTO){
        return internshipService.saveInternship(internshipSaveDTO);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("all")
    public List<InternshipDetailResponseDTO> internshipDetailAll(){
        return internshipService.detailInternshipAll();
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("approved/all")
    public List<InternshipDetailResponseDTO> approvedInternshipDetailAll(){
        return internshipService.detailApprovedInternshipAll();
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("allTest")
    public List<Internship> internship(){
        return internshipService.getAll();
    }




}
