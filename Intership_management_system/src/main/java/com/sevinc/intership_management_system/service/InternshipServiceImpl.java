package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.controller.InternshipDocumentController;
import com.sevinc.intership_management_system.convert.CompanyConverter;
import com.sevinc.intership_management_system.convert.CompanyExecutiveConverter;
import com.sevinc.intership_management_system.convert.InternshipConverter;
import com.sevinc.intership_management_system.dto.*;
import com.sevinc.intership_management_system.model.*;
import com.sevinc.intership_management_system.repository.InternshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InternshipServiceImpl implements InternshipService{

    private final InternshipRepository internshipRepository;
    private final InternshipConverter internshipConverter;
    private final InternshipDocumentService internshipDocumentService;
    private final StudentService studentService;
    private final AddressService addressService;
    private final CompanyService companyService;
    private final CompanyExecutiveService companyExecutiveService;
    private final ApprovedService approvedService;
    private final InternshipDocumentController internshipDocumentController;
    private final CompanyExecutiveConverter companyExecutiveConverter;
    private final CompanyConverter companyConverter;

    @Override
    @Transactional
    public InternshipResponseDTO saveInternship(InternshipSaveDTO internshipSaveDTO){

        Student student = studentService.getByStudentId(internshipSaveDTO.getStudentId());


       InternshipDocument internshipDocument = internshipDocumentService.getByInternshipDocument(internshipSaveDTO.getInternshipDocumentId());

        AddressResponseDTO addressResponseDTO = addressService.saveAddress(internshipSaveDTO.getAddressSaveFullIdDTO());
        internshipSaveDTO.getCompanySaveIdDTO().setAddressId(addressResponseDTO.getAddressId());

        CompanyResponseDTO companyResponseDTO = companyService.saveCompany(internshipSaveDTO.getCompanySaveIdDTO());
        internshipSaveDTO.getCompanyExecutiveSaveIdDTO().setCompanyId(companyResponseDTO.getCompanyId());
        CompanyExecutiveResponseDTO companyExecutiveResponseDTO = companyExecutiveService.saveCompanyExecutive(
                internshipSaveDTO.getCompanyExecutiveSaveIdDTO()
        );

        Company company = companyService.getByCompanyId(companyResponseDTO.getCompanyId());
        CompanyExecutive companyExecutive = companyExecutiveService.getByCompanyExecutiveId(companyExecutiveResponseDTO.getCompanyExecutiveId());

        ApprovedResponseDTO approvedResponseDTO = approvedService.getDefaultSaveApproved();


        Internship internship = new Internship();
        internship.setStudentId(student);
        internship.setInternshipDay(internshipSaveDTO.getInternshipDay());
       internship.setInternshipDocumentId(internshipDocument);
        internship.setDate(new Date());
        internship.setCompanyExecutiveId(companyExecutive);
        internship.setCompanyId(company);
        internship.setAccepted_day(internshipSaveDTO.getAccepted_day());
        internship.setFinishDate(internshipSaveDTO.getFinishDate());
        internship.setEnabled(internshipSaveDTO.getInternshipEnabled());
        internship.setIsThirdLesson(internshipSaveDTO.getIsThirdLesson());
        internship.setStartDate(internshipSaveDTO.getStartDate());
        internship.setApprovedId(approvedService.getByApprovedId(approvedResponseDTO.getApprovedId()));

        internship = internshipRepository.save(internship);
        student.setInternships(internship.getStudentId().getInternships());
        return internshipConverter.convertInternshipResponse(internship);
    }

    @Override
    @Transactional
    public List<InternshipDetailResponseDTO> detailInternshipAll() {
        List<Internship> internshipList = internshipRepository.findAll();
        return internshipList.stream()
                .map(internship -> internshipConverter.convertInternshipDetailResponse(internship))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public List<InternshipDetailResponseDTO> detailApprovedInternshipAll() {
        List<Internship> internshipList = internshipRepository.approvedIntership();
        return internshipList.stream()
                .map(internship -> internshipConverter.convertInternshipDetailResponse(internship))
                .collect(Collectors.toList());
    }

    @Override
    public List<Internship> getAll() {
        return internshipRepository.findAll();
    }
}
