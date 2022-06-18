package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.dto.GeneralDocumentResponseDTO;
import com.sevinc.intership_management_system.service.GeneralDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("general-document")
@RequiredArgsConstructor
@CrossOrigin
public class GeneralDocumentController {

    private final GeneralDocumentService generalDocumentService;

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("save")
    public GeneralDocumentResponseDTO saveGeneralDocument(@RequestParam("file") MultipartFile file , Boolean state){
        return generalDocumentService.save(file, state);
    }
}
