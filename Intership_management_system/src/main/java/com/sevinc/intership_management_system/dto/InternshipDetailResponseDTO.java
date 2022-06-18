package com.sevinc.intership_management_system.dto;

import com.sevinc.intership_management_system.model.InternshipDocument;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternshipDetailResponseDTO extends InternshipResponseDTO{

    private InternshipDocumentResponseDTO transcriptFile;
    private InternshipDocumentResponseDTO applicationFile;
    private InternshipDocumentResponseDTO bookFile;
    private StudentResponseDTO studentResponseDTO;
    private StudentIdentityResponseDTO studentIdentityResponseDTO;

//    List<Student> studentList;
//    List<InternshipDocument> internshipDocumentList;
//    List<CompanyResponseDTO> companyResponseDTOList;
//    List<CompanyExecutiveResponseDTO> companyExecutiveResponseDTOList;
//    List<Internship> internshipList;
//    List<InternshipDocument> transcriptFileList;
//    List<InternshipDocument> bookFileList;
//    List<InternshipDocument> applicationFileList;
}
