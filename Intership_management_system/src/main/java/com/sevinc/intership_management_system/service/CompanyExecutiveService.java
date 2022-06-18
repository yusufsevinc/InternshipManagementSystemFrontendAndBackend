package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.dto.CompanyExecutiveResponseDTO;
import com.sevinc.intership_management_system.dto.CompanyExecutiveSaveDTO;
import com.sevinc.intership_management_system.dto.CompanyExecutiveSaveIdDTO;
import com.sevinc.intership_management_system.model.CompanyExecutive;

import java.util.List;

public interface CompanyExecutiveService {
    CompanyExecutiveResponseDTO saveCompanyExecutive(CompanyExecutiveSaveDTO companyExecutiveSaveDto);

    CompanyExecutiveResponseDTO saveCompanyExecutive(CompanyExecutiveSaveIdDTO companyExecutiveSaveIdDto);

    List<CompanyExecutiveResponseDTO> getAllActiveOrPassiveCompanyExecutive(Boolean state);

    List<CompanyExecutiveResponseDTO> getAllCompanyExecutive();

    List<CompanyExecutiveResponseDTO> getAllCompanyExecutiveAndCompany(Long id);

    CompanyExecutiveResponseDTO getByCompanyExecutiveResponseDtoId(Long companyExecutiveId);

    CompanyExecutive getByCompanyExecutiveId(Long companyExecutiveId);

    boolean getDeleteCompany(Long companyExecutiveId);
}
