package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.dto.CompanyResponseDTO;
import com.sevinc.intership_management_system.dto.CompanySaveDTO;
import com.sevinc.intership_management_system.dto.CompanySaveIdDTO;
import com.sevinc.intership_management_system.model.Company;

import java.util.List;

public interface CompanyService {
    CompanyResponseDTO saveCompany(CompanySaveDTO companySaveDto);

    CompanyResponseDTO saveCompany(CompanySaveIdDTO companySaveIdDto);

    List<CompanyResponseDTO> getAllActiveOrPassiveCompany(Boolean state);

    List<CompanyResponseDTO> getAllCompany();

    CompanyResponseDTO getByCompanyResponseDtoId(Long companyId);

    Company getByCompanyId(Long companyId);

    boolean getDeleteCompany(Long companyId);
}
