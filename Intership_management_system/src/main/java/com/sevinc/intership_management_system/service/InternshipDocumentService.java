package com.sevinc.intership_management_system.service;


import com.sevinc.intership_management_system.dto.InternshipDocumentDTO;
import com.sevinc.intership_management_system.dto.InternshipDocumentResponseDTO;
import com.sevinc.intership_management_system.model.FileTitleEnum;
import com.sevinc.intership_management_system.model.InternshipDocument;
import com.sevinc.intership_management_system.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InternshipDocumentService {
    InternshipDocumentResponseDTO save(MultipartFile multipartFile, InternshipDocumentDTO internshipDocumentDTO);

    InternshipDocumentResponseDTO getByInternshipDocumentResponse(Long internshipDocumentId);

    InternshipDocument getByInternshipDocument(Long internshipDocumentId);

    List<InternshipDocument> internshipDocumentAll();
    InternshipDocumentResponseDTO internshipDocumentAllType(FileTitleEnum name,Student student);

    InternshipDocumentResponseDTO internshipDocumentAllType(FileTitleEnum name);

    void saveInternshipDocument2(MultipartFile file, String title, Student student);
}
