package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.convert.CompanyExecutiveConverter;
import com.sevinc.intership_management_system.dto.CompanyExecutiveResponseDTO;
import com.sevinc.intership_management_system.dto.CompanyExecutiveSaveDTO;
import com.sevinc.intership_management_system.dto.CompanyExecutiveSaveIdDTO;
import com.sevinc.intership_management_system.exceptions.ServiceRuntimeException;
import com.sevinc.intership_management_system.model.Company;
import com.sevinc.intership_management_system.model.CompanyExecutive;
import com.sevinc.intership_management_system.repository.CompanyExecutiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyExecutiveServiceImpl implements CompanyExecutiveService{

    private final CompanyExecutiveConverter companyExecutiveConverter;
    private final CompanyExecutiveRepository companyExecutiveRepository;
    private final CompanyService companyService;

    @Override
    @Transactional
    public CompanyExecutiveResponseDTO saveCompanyExecutive(CompanyExecutiveSaveDTO companyExecutiveSaveDto){
        CompanyExecutive companyExecutive = companyExecutiveConverter.convertCompanyExecutive(companyExecutiveSaveDto);
        companyExecutive = companyExecutiveRepository.save(companyExecutive);
        return companyExecutiveConverter.convertCompanyExecutiveResponse(companyExecutive);
    }

    @Override
    @Transactional
    public CompanyExecutiveResponseDTO saveCompanyExecutive(CompanyExecutiveSaveIdDTO companyExecutiveSaveIdDto) {
        Company company = companyService.getByCompanyId(companyExecutiveSaveIdDto.getCompanyId());
        CompanyExecutive companyExecutive = companyExecutiveConverter.convertCompanyExecutive(companyExecutiveSaveIdDto);
        companyExecutive.setCompany(company);
        companyExecutive = companyExecutiveRepository.save(companyExecutive);
        return companyExecutiveConverter.convertCompanyExecutiveResponse(companyExecutive);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyExecutiveResponseDTO> getAllActiveOrPassiveCompanyExecutive(Boolean state) {
        List<CompanyExecutive> companyExecutiveList = companyExecutiveRepository.findCompanyExecutiveByCompanyExecutiveId(state);
        return companyExecutiveList.stream()
                .map(companyExecutive -> companyExecutiveConverter.convertCompanyExecutiveResponse(companyExecutive))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyExecutiveResponseDTO> getAllCompanyExecutive() {
        List<CompanyExecutive> companyExecutiveList = companyExecutiveRepository.findAll();
        return companyExecutiveList.stream()
                .map(companyExecutive -> companyExecutiveConverter.convertCompanyExecutiveResponse(companyExecutive))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyExecutiveResponseDTO> getAllCompanyExecutiveAndCompany(Long id) {
        List<CompanyExecutive> companyExecutiveList = companyExecutiveRepository.findCompanyExecutiveByCompanyId(id);
        return companyExecutiveList.stream()
                .map(companyExecutive -> companyExecutiveConverter.convertCompanyExecutiveResponse(companyExecutive))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CompanyExecutiveResponseDTO getByCompanyExecutiveResponseDtoId(Long companyExecutiveId) {
        final var companyExecutive = companyExecutiveRepository.findById(companyExecutiveId)
                .orElseThrow(() -> new ServiceRuntimeException("CompanyExecutive Not Found"));
        CompanyExecutiveResponseDTO companyResponseDto = companyExecutiveConverter.convertCompanyExecutiveResponse(companyExecutive);
        return companyResponseDto;
    }

    @Override
    @Transactional(readOnly = true)
    public CompanyExecutive getByCompanyExecutiveId(Long companyExecutiveId) {
        final var companyExecutive = companyExecutiveRepository.findById(companyExecutiveId)
                .orElseThrow(() -> new ServiceRuntimeException("CompanyExecutive Not Found"));
        return companyExecutive;
    }

    @Override
    @Transactional
    public boolean getDeleteCompany(Long companyExecutiveId) {
        CompanyExecutive companyExecutive = getByCompanyExecutiveId(companyExecutiveId);
        if (companyExecutive.getCompanyExecutiveId() == companyExecutiveId) {
            companyExecutiveRepository.deleteCompanyExecutiveByCompanyExecutiveId(companyExecutiveId);
            return true;
        } else {
            return false;
        }
    }


}
