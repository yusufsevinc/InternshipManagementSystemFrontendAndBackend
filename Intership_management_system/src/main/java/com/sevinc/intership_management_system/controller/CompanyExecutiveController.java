package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.dto.CompanyExecutiveResponseDTO;
import com.sevinc.intership_management_system.dto.CompanyExecutiveSaveDTO;
import com.sevinc.intership_management_system.dto.CompanyExecutiveSaveIdDTO;
import com.sevinc.intership_management_system.service.CompanyExecutiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company-executive")
@RequiredArgsConstructor
@CrossOrigin
public class CompanyExecutiveController {
    private final CompanyExecutiveService companyExecutiveService;

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("save")
    public CompanyExecutiveResponseDTO saveCompanyExecutive(@RequestBody CompanyExecutiveSaveDTO companyExecutiveSaveDto) {
        return companyExecutiveService.saveCompanyExecutive(companyExecutiveSaveDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("id-with-save")
    public CompanyExecutiveResponseDTO saveCompanyExecutive(@RequestBody CompanyExecutiveSaveIdDTO companyExecutiveSaveIdDto) {
        return companyExecutiveService.saveCompanyExecutive(companyExecutiveSaveIdDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("all/{state}")
    public List<CompanyExecutiveResponseDTO> companyExecutiveActiveOrPassiveAll(@PathVariable("state") Boolean state) {
        return companyExecutiveService.getAllActiveOrPassiveCompanyExecutive(state);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("all")
    public List<CompanyExecutiveResponseDTO> companyExecutiveAll() {
        return companyExecutiveService.getAllCompanyExecutive();
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("{id}")
    public CompanyExecutiveResponseDTO getByCompanyExecutiveId(@PathVariable("id") Long id) {
        return companyExecutiveService.getByCompanyExecutiveResponseDtoId(id);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("detail/{id}")
    public List<CompanyExecutiveResponseDTO> getByCompanyExecutiveIdAndCompany(@PathVariable("id") Long id) {
        return companyExecutiveService.getAllCompanyExecutiveAndCompany(id);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @DeleteMapping("delete/{id}")
    public boolean companyExecutiveDelete(@PathVariable("id") Long id){
        return companyExecutiveService.getDeleteCompany(id);
    }
}
