package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.CompanyExecutiveResponseDTO;
import com.sevinc.intership_management_system.dto.CompanyExecutiveSaveDTO;
import com.sevinc.intership_management_system.dto.CompanyExecutiveSaveIdDTO;
import com.sevinc.intership_management_system.dto.CompanyResponseDTO;
import com.sevinc.intership_management_system.model.Company;
import com.sevinc.intership_management_system.model.CompanyExecutive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyExecutiveConverter {

    private final CompanyConverter companyConverter;

    public CompanyExecutive convertCompanyExecutive(CompanyExecutiveSaveDTO companyExecutiveSaveDto){
        CompanyExecutive companyExecutive = new CompanyExecutive();
        Company company = companyConverter.convertCompany(companyExecutiveSaveDto.getCompany());

        companyExecutive.setCompanyExecutiveEmail(companyExecutiveSaveDto.getCompanyExecutiveEmail());
        companyExecutive.setCompanyExecutiveName(companyExecutiveSaveDto.getCompanyExecutiveName());
        companyExecutive.setEnabled(companyExecutiveSaveDto.getEnabled());
        companyExecutive.setCompanyExecutivePhone(companyExecutiveSaveDto.getCompanyExecutivePhone());
        companyExecutive.setCompanyExecutiveSurname(companyExecutiveSaveDto.getCompanyExecutiveSurname());
        companyExecutive.setCompanyExecutiveTitle(companyExecutiveSaveDto.getCompanyExecutiveTitle());
        companyExecutive.setCompany(company);
        return companyExecutive;
    }


    public CompanyExecutiveResponseDTO convertCompanyExecutiveResponse(CompanyExecutive companyExecutive){
        CompanyExecutiveResponseDTO companyExecutiveResponseDto = new CompanyExecutiveResponseDTO();
        CompanyResponseDTO companyResponseDto = companyConverter.convertCompany(companyExecutive.getCompany());

        companyExecutiveResponseDto.setCompany(companyResponseDto);
        companyExecutiveResponseDto.setCompanyExecutivePhone(companyExecutive.getCompanyExecutivePhone());
        companyExecutiveResponseDto.setCompanyExecutiveId(companyExecutive.getCompanyExecutiveId());
        companyExecutiveResponseDto.setCompanyExecutiveEmail(companyExecutive.getCompanyExecutiveEmail());
        companyExecutiveResponseDto.setCompanyExecutiveName(companyExecutive.getCompanyExecutiveName());
        companyExecutiveResponseDto.setCompanyExecutiveSurname(companyExecutive.getCompanyExecutiveSurname());
        companyExecutiveResponseDto.setCompanyExecutiveTitle(companyExecutive.getCompanyExecutiveTitle());
        companyExecutiveResponseDto.setEnabled(companyExecutive.getEnabled());
        return companyExecutiveResponseDto;
    }

    public CompanyExecutive convertCompanyExecutive(CompanyExecutiveSaveIdDTO companyExecutiveSaveIdDto){
        CompanyExecutive companyExecutive = new CompanyExecutive();

        companyExecutive.setCompanyExecutiveName(companyExecutiveSaveIdDto.getCompanyExecutiveName());
        companyExecutive.setCompanyExecutiveEmail(companyExecutiveSaveIdDto.getCompanyExecutiveEmail());
        companyExecutive.setCompanyExecutiveSurname(companyExecutiveSaveIdDto.getCompanyExecutiveSurname());
        companyExecutive.setCompanyExecutiveTitle(companyExecutiveSaveIdDto.getCompanyExecutiveTitle());
        companyExecutive.setEnabled(companyExecutiveSaveIdDto.getEnabled());
        companyExecutive.setCompanyExecutivePhone(companyExecutiveSaveIdDto.getCompanyExecutivePhone());
        return companyExecutive;
    }
}
