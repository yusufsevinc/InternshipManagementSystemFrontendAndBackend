package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.convert.ApprovedConverter;
import com.sevinc.intership_management_system.convert.StudentConverter;
import com.sevinc.intership_management_system.dto.ApprovedSaveDTO;
import com.sevinc.intership_management_system.dto.InternshipDocumentDTO;
import com.sevinc.intership_management_system.dto.InternshipDocumentResponseDTO;
import com.sevinc.intership_management_system.model.Approved;
import com.sevinc.intership_management_system.model.FileTitleEnum;
import com.sevinc.intership_management_system.model.InternshipDocument;
import com.sevinc.intership_management_system.model.Student;
import com.sevinc.intership_management_system.repository.InternshipDocumenRepository;
import com.sevinc.intership_management_system.service.ApprovedService;
import com.sevinc.intership_management_system.service.InternshipDocumentService;
import com.sevinc.intership_management_system.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.sevinc.intership_management_system.model.FileTitleEnum.TRANSCRIPT;
import static com.sevinc.intership_management_system.util.DateFormatUtils.*;

@RestController
@RequestMapping("internship-document")
@RequiredArgsConstructor
@CrossOrigin
public class InternshipDocumentController {
    private final InternshipDocumentService internshipDocumentService;
    private final ApprovedConverter approvedConverter;
    private final ApprovedService approvedService;
    private final StudentService studentService;
    private final InternshipDocumenRepository internshipDocumenRepository;

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("save")
    public InternshipDocumentResponseDTO saveInternshipDocument(@RequestParam("file") MultipartFile file,
                                                                InternshipDocumentDTO internshipDocumentDTO) {
        return internshipDocumentService.save(file, internshipDocumentDTO);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("save2")
    @Transactional
    public void saveInternshipDocument2(@RequestParam("file") MultipartFile file, @RequestParam("title") String title ,
                                        @RequestParam("studentId") String studentId) {
        FileTitleEnum fileTitleEnum = FileTitleEnum.valueOf(title);
        InternshipDocument internshipDocument = new InternshipDocument();
        ApprovedSaveDTO approvedSaveDTO = new ApprovedSaveDTO();
        approvedSaveDTO.setAssistantDean(false);
        approvedSaveDTO.setCommission(false);
        approvedSaveDTO.setHeadOfDepartment(false);
        Student student = studentService.getByStudentId(Long.valueOf(studentId));
        Approved approved = approvedConverter.convertApproved(approvedSaveDTO);
        try {
            internshipDocument.setDocumentData(file.getBytes());
            internshipDocument.setDocumentName(file.getOriginalFilename());
            internshipDocument.setDocumentType(file.getContentType());
            internshipDocument.setApprovedId(approved);
            internshipDocument.setEnabled(true);
            internshipDocument.setStudentId(student);
            internshipDocument.setCreationDate(formatBirthdate(formatDate(new Date(), DATE)));
            internshipDocument.setFileTitleEnum(fileTitleEnum);

            internshipDocumenRepository.save(internshipDocument);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("{id}")
    public InternshipDocumentResponseDTO getByInternshipDocumentId(@PathVariable Long id) {
        return internshipDocumentService.getByInternshipDocumentResponse(id);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("all/{id}")
    public InternshipDocumentResponseDTO getByInternshipDocumentId(@PathVariable FileTitleEnum id) {
        return internshipDocumentService.internshipDocumentAllType(id);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long id) {
        InternshipDocument internshipDocument = internshipDocumentService.getByInternshipDocument(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(internshipDocument.getDocumentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + internshipDocument.getDocumentName() + "\"")
                .body(new ByteArrayResource(internshipDocument.getDocumentData()));
    }


//    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
//    @GetMapping("download/{id}")
//    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long id) {
//        InternshipDocument internshipDocument = internshipDocumentService.getByInternshipDocument(id);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(internshipDocument.getDocumentType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + internshipDocument.getDocumentName() + "\"")
//                .body(new ByteArrayResource(internshipDocument.getDocumentData()));
//    }


}
