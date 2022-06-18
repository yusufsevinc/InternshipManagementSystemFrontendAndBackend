package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.dto.CompanyResponseDTO;
import com.sevinc.intership_management_system.dto.CompanySaveDTO;
import com.sevinc.intership_management_system.dto.CompanySaveIdDTO;
import com.sevinc.intership_management_system.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
@RequiredArgsConstructor
@CrossOrigin
public class CompanyController {

    private final CompanyService companyService;

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("save")
    public CompanyResponseDTO saveCompany(@RequestBody CompanySaveDTO companySaveDto) {
        return companyService.saveCompany(companySaveDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("id-with-save")
    public CompanyResponseDTO saveCompany(@RequestBody CompanySaveIdDTO companySaveIdDto) {
        return companyService.saveCompany(companySaveIdDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("all/{state}")
    public List<CompanyResponseDTO> companyActiveOrPassiveAll(@PathVariable("state") Boolean state) {
        return companyService.getAllActiveOrPassiveCompany(state);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("all")
    public List<CompanyResponseDTO> companyAll() {
        return companyService.getAllCompany();
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("{id}")
    public CompanyResponseDTO getByCompanyId(@PathVariable("id") Long id) {
        return companyService.getByCompanyResponseDtoId(id);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @DeleteMapping("delete/{id}")
    public boolean companyDelete(@PathVariable("id") Long id) {
        return companyService.getDeleteCompany(id);
    }
}
