package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.AddressResponseDTO;
import com.sevinc.intership_management_system.dto.CompanyResponseDTO;
import com.sevinc.intership_management_system.dto.CompanySaveDTO;
import com.sevinc.intership_management_system.dto.CompanySaveIdDTO;
import com.sevinc.intership_management_system.model.Address;
import com.sevinc.intership_management_system.model.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyConverter {

    private final AddressConverter addressConverter;

    public Company convertCompany(CompanySaveDTO companySaveDto) {
        Company company = new Company();
        Address address = addressConverter.addressConverter(companySaveDto.getAddress());

        company.setCompanyEmail(companySaveDto.getCompanyEmail());
        company.setCompanyPhone(companySaveDto.getCompanyPhone());
        company.setCompanyName(companySaveDto.getCompanyName());
        company.setEnabled(companySaveDto.getEnabled());
        company.setAddressId(address);

        return company;
    }

    public CompanyResponseDTO convertCompany(Company company) {
        CompanyResponseDTO companyResponseDto = new CompanyResponseDTO();
        AddressResponseDTO addressResponseDto = addressConverter.addressConverter(company.getAddressId());
        companyResponseDto.setCompanyId(company.getCompanyId());
        companyResponseDto.setCompanyEmail(company.getCompanyEmail());
        companyResponseDto.setCompanyName(company.getCompanyName());
        companyResponseDto.setCompanyPhone(company.getCompanyPhone());
        companyResponseDto.setEnabled(company.getEnabled());
        companyResponseDto.setAddress(addressResponseDto);

        return companyResponseDto;
    }

    public Company convertCompany(CompanySaveIdDTO companySaveIdDto) {
        Company company = new Company();
        company.setCompanyName(companySaveIdDto.getCompanyName());
        company.setCompanyPhone(companySaveIdDto.getCompanyPhone());
        company.setCompanyEmail(companySaveIdDto.getCompanyEmail());
        company.setEnabled(companySaveIdDto.getEnabled());
        return company;
    }
}
