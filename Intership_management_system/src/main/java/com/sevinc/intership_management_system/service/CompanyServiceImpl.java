package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.convert.CompanyConverter;
import com.sevinc.intership_management_system.dto.CompanyResponseDTO;
import com.sevinc.intership_management_system.dto.CompanySaveDTO;
import com.sevinc.intership_management_system.dto.CompanySaveIdDTO;
import com.sevinc.intership_management_system.exceptions.ServiceRuntimeException;
import com.sevinc.intership_management_system.model.Address;
import com.sevinc.intership_management_system.model.Company;
import com.sevinc.intership_management_system.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyConverter companyConverter;
    private final CompanyRepository companyRepository;
    private final AddressService addressService;

    @Override
    @Transactional
    public CompanyResponseDTO saveCompany(CompanySaveDTO companySaveDto) {
        Company company = companyConverter.convertCompany(companySaveDto);
        company = companyRepository.save(company);
        return companyConverter.convertCompany(company);
    }

    @Override
    @Transactional
    public CompanyResponseDTO saveCompany(CompanySaveIdDTO companySaveIdDto) {
        Address address = addressService.getByAddressId(companySaveIdDto.getAddressId());
        Company company = companyConverter.convertCompany(companySaveIdDto);
        company.setAddressId(address);
        company = companyRepository.save(company);
        return companyConverter.convertCompany(company);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyResponseDTO> getAllActiveOrPassiveCompany(Boolean state) {
        List<Company> companyList = companyRepository.findCompanyByCompanyId(state);
        return companyList.stream()
                .map(company -> companyConverter.convertCompany(company))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyResponseDTO> getAllCompany() {
        List<Company> companyList = companyRepository.findAll();
        return companyList.stream()
                .map(company -> companyConverter.convertCompany(company))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CompanyResponseDTO getByCompanyResponseDtoId(Long companyId) {
        final var company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ServiceRuntimeException("Company Not Found"));
        CompanyResponseDTO companyResponseDto = companyConverter.convertCompany(company);
        return companyResponseDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Company getByCompanyId(Long companyId) {
        final var company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ServiceRuntimeException("Company Not Found"));
        return company;
    }

    @Override
    @Transactional
    public boolean getDeleteCompany(Long companyId) {
        Company company = getByCompanyId(companyId);
        if (company.getCompanyId() == companyId){
            companyRepository.deleteCompanyByCompanyId(companyId);
            return true;
        } else {
            return false;
        }
    }
}
