package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.dto.InternshipDetailResponseDTO;
import com.sevinc.intership_management_system.dto.InternshipResponseDTO;
import com.sevinc.intership_management_system.dto.InternshipSaveDTO;
import com.sevinc.intership_management_system.model.Internship;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InternshipService {
    InternshipResponseDTO saveInternship(InternshipSaveDTO internshipSaveDTO);
    List<InternshipDetailResponseDTO> detailInternshipAll();


    @Transactional
    List<InternshipDetailResponseDTO> detailApprovedInternshipAll();

    List<Internship> getAll();
}
