package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.convert.ApprovedConverter;
import com.sevinc.intership_management_system.convert.InternshipDocumentConverter;
import com.sevinc.intership_management_system.dto.ApprovedSaveDTO;
import com.sevinc.intership_management_system.dto.InternshipDocumentDTO;
import com.sevinc.intership_management_system.dto.InternshipDocumentResponseDTO;
import com.sevinc.intership_management_system.exceptions.ServiceRuntimeException;
import com.sevinc.intership_management_system.model.Approved;
import com.sevinc.intership_management_system.model.FileTitleEnum;
import com.sevinc.intership_management_system.model.InternshipDocument;
import com.sevinc.intership_management_system.model.Student;
import com.sevinc.intership_management_system.repository.InternshipDocumenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.sevinc.intership_management_system.util.DateFormatUtils.*;

@Service
@RequiredArgsConstructor
public class InternshipDocumentServiceImpl implements InternshipDocumentService {

    private final InternshipDocumenRepository internshipDocumenRepository;
    private final InternshipDocumentConverter internshipDocumentConverter;
    private final ApprovedConverter approvedConverter;

    @Override
    @Transactional
    public InternshipDocumentResponseDTO save(MultipartFile multipartFile, InternshipDocumentDTO internshipDocumentDTO) {
        InternshipDocument internshipDocument = internshipDocumentConverter.saveInternshipDocument(
                multipartFile,internshipDocumentDTO);

        internshipDocument = internshipDocumenRepository.save(internshipDocument);
        return internshipDocumentConverter.convertInternshipDocumentResponse(internshipDocument);
    }

    @Override
    @Transactional(readOnly = true)
    public InternshipDocumentResponseDTO getByInternshipDocumentResponse(Long internshipDocumentId){
        final var internshipDocument = internshipDocumenRepository.findById(internshipDocumentId)
                .orElseThrow(() -> new ServiceRuntimeException("Internship Document Not Found"));

        InternshipDocumentResponseDTO internshipDocumentResponseDTO = internshipDocumentConverter.convertInternshipDocumentResponse(internshipDocument);
        return internshipDocumentResponseDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public InternshipDocument getByInternshipDocument(Long internshipDocumentId){
        final var internshipDocument = internshipDocumenRepository.findById(internshipDocumentId)
                .orElseThrow(() -> new ServiceRuntimeException("Internship Document Not Found"));
        return internshipDocument;
    }

    @Override
    @Transactional(readOnly = true)
    public List<InternshipDocument> internshipDocumentAll(){
        return internshipDocumenRepository.findAll();
    }

    @Override
    public InternshipDocumentResponseDTO internshipDocumentAllType(FileTitleEnum name, Student student) {
        final var internshipDocument = internshipDocumenRepository.findByFileTitleEnumAndStudentId(name,student);
        if (internshipDocument == null) {
            return null;
        } else {

            InternshipDocumentResponseDTO internshipDocumentResponseDTO = internshipDocumentConverter.convertInternshipDocumentResponse(internshipDocument);
            return internshipDocumentResponseDTO;
        }
    }

    @Override
    public InternshipDocumentResponseDTO internshipDocumentAllType(FileTitleEnum name) {
        final var internshipDocument = internshipDocumenRepository.findByFileTitleEnum(name);
        if (internshipDocument == null) {
            return null;
        } else {

            InternshipDocumentResponseDTO internshipDocumentResponseDTO = internshipDocumentConverter.convertInternshipDocumentResponse(internshipDocument);
            return internshipDocumentResponseDTO;
        }

    }

    @Override
    @Transactional
    public void saveInternshipDocument2(MultipartFile file, String title, Student student) {
        FileTitleEnum fileTitleEnum = FileTitleEnum.valueOf(title);
        InternshipDocument internshipDocument = new InternshipDocument();
        ApprovedSaveDTO approvedSaveDTO = new ApprovedSaveDTO();
        approvedSaveDTO.setAssistantDean(false);
        approvedSaveDTO.setCommission(false);
        approvedSaveDTO.setHeadOfDepartment(false);
        internshipDocument.setStudentId(student);
        Approved approved = approvedConverter.convertApproved(approvedSaveDTO);
        try {
            internshipDocument.setDocumentData(file.getBytes());
            internshipDocument.setDocumentName(file.getOriginalFilename());
            internshipDocument.setDocumentType(file.getContentType());
            internshipDocument.setApprovedId(approved);
            internshipDocument.setEnabled(true);
            internshipDocument.setCreationDate(formatBirthdate(formatDate(new Date(), DATE)));
            internshipDocument.setFileTitleEnum(fileTitleEnum);

            internshipDocumenRepository.save(internshipDocument);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
