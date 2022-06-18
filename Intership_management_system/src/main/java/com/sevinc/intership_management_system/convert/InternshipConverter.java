package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.InternshipDetailResponseDTO;
import com.sevinc.intership_management_system.dto.InternshipResponseDTO;
import com.sevinc.intership_management_system.dto.InternshipSaveDTO;
import com.sevinc.intership_management_system.model.Internship;
import com.sevinc.intership_management_system.service.InternshipDocumentService;
import com.sevinc.intership_management_system.service.StudentService;
import com.sevinc.intership_management_system.util.DateFormatUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.sevinc.intership_management_system.model.FileTitleEnum.*;

@Component
@RequiredArgsConstructor
public class InternshipConverter {

    private final InternshipDocumentService internshipDocumentService;
    private final CompanyConverter companyConverter;
    private final CompanyExecutiveConverter companyExecutiveConverter;
    private final StudentService studentService;
    private final ApprovedConverter approvedConverter;


    private final StudentConverter studentConverter;

    private final StudentIdentityConverter studentIdentityConverter;

    public Internship convertInternship(InternshipSaveDTO internshipSaveDTO){
        Internship internship = new Internship();


//        internship.setInternshipDocumentId(internshipDocumentService.getByInternshipDocument(
//                internshipSaveDTO.getInternshipDocumentId()
//        ));
        internship.setInternshipDay(internshipSaveDTO.getInternshipDay());
        internship.setEnabled(internshipSaveDTO.getInternshipEnabled());
        internship.setStartDate(internshipSaveDTO.getStartDate());
        internship.setFinishDate(internshipSaveDTO.getFinishDate());
        internship.setAccepted_day(internshipSaveDTO.getAccepted_day());
        internship.setDate(internshipSaveDTO.getDate());
        internship.setIsThirdLesson(internshipSaveDTO.getIsThirdLesson());
        internship.setCompanyExecutiveId(companyExecutiveConverter.convertCompanyExecutive(
                internshipSaveDTO.getCompanyExecutiveSaveIdDTO()
        ));
        internship.setCompanyId(companyConverter.convertCompany(internshipSaveDTO.getCompanySaveIdDTO()));
        internship.setStudentId(studentService.getByStudentId(internshipSaveDTO.getStudentId()));

        return internship;
    }

    public InternshipResponseDTO convertInternshipResponse(Internship internship){
        InternshipResponseDTO internshipResponseDTO = new InternshipResponseDTO();

        internshipResponseDTO.setCompanyResponseDTO(companyConverter.convertCompany(internship.getCompanyId()));
        internshipResponseDTO.setCompanyExecutiveResponseDTO(companyExecutiveConverter
                .convertCompanyExecutiveResponse(internship.getCompanyExecutiveId()));
        internshipResponseDTO.setInternshipEnabled(internship.getEnabled());
        internshipResponseDTO.setInternshipDay(internship.getInternshipDay());
        //internshipResponseDTO.setInternshipDocumentId(internship.getInternshipDocumentId().getInternshipDocumentId());
        internshipResponseDTO.setAccepted_day(internship.getAccepted_day());
        internshipResponseDTO.setDate(internship.getDate());
        internshipResponseDTO.setFinishDate(DateFormatUtils.getDateFormat(internship.getFinishDate()));
        internshipResponseDTO.setStartDate(DateFormatUtils.getDateFormat(internship.getStartDate()));
        internshipResponseDTO.setInternshipId(internship.getInternshipId());
        internshipResponseDTO.setStudentId(internship.getInternshipId());
        internshipResponseDTO.setIsThirdLesson(internship.getIsThirdLesson());
        internshipResponseDTO.setApprovedResponseDTO(approvedConverter.convertApprovedResponse(internship.getApprovedId()));
        return internshipResponseDTO;

    }

    public InternshipDetailResponseDTO convertInternshipDetailResponse(Internship internship){
        InternshipDetailResponseDTO internshipDetailResponseDTO = new InternshipDetailResponseDTO();

        internshipDetailResponseDTO.setCompanyResponseDTO(companyConverter.convertCompany(internship.getCompanyId()));
        internshipDetailResponseDTO.setCompanyExecutiveResponseDTO(companyExecutiveConverter
                .convertCompanyExecutiveResponse(internship.getCompanyExecutiveId()));
        internshipDetailResponseDTO.setInternshipEnabled(internship.getEnabled());
        internshipDetailResponseDTO.setInternshipDay(internship.getInternshipDay());
        //internshipDetailResponseDTO.setInternshipDocumentId(internship.getInternshipDocumentId().getInternshipDocumentId());
        internshipDetailResponseDTO.setAccepted_day(internship.getAccepted_day());
        internshipDetailResponseDTO.setDate(internship.getDate());
        internshipDetailResponseDTO.setFinishDate(DateFormatUtils.getDateFormat(internship.getFinishDate()));
        internshipDetailResponseDTO.setStartDate(DateFormatUtils.getDateFormat(internship.getStartDate()));
        internshipDetailResponseDTO.setInternshipId(internship.getInternshipId());
        internshipDetailResponseDTO.setStudentId(internship.getInternshipId());
        internshipDetailResponseDTO.setIsThirdLesson(internship.getIsThirdLesson());
        internshipDetailResponseDTO.setApprovedResponseDTO(approvedConverter.convertApprovedResponse(internship.getApprovedId()));
        internshipDetailResponseDTO.setStudentResponseDTO(studentConverter.convertStudentResponse(internship.getStudentId()));
        internshipDetailResponseDTO.setApplicationFile(internshipDocumentService.internshipDocumentAllType(INTERNSHIP_APPLICATION_FORM,internship.getStudentId()));
        internshipDetailResponseDTO.setStudentIdentityResponseDTO(studentIdentityConverter.convertStudentIdentityResponse(internship.getStudentId().getStudentIdentityId()));
        if (internshipDocumentService.internshipDocumentAllType(INTERNSHIP_BOOK,internship.getStudentId()) == null){

        }else{
            internshipDetailResponseDTO.setBookFile(internshipDocumentService.internshipDocumentAllType(INTERNSHIP_BOOK,internship.getStudentId()));
        }
        internshipDetailResponseDTO.setTranscriptFile(internshipDocumentService.internshipDocumentAllType(TRANSCRIPT,internship.getStudentId()));

        return internshipDetailResponseDTO;

    }
}
