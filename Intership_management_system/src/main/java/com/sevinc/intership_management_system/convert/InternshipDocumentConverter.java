package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.ApprovedResponseDTO;
import com.sevinc.intership_management_system.dto.ApprovedSaveDTO;
import com.sevinc.intership_management_system.dto.InternshipDocumentDTO;
import com.sevinc.intership_management_system.dto.InternshipDocumentResponseDTO;
import com.sevinc.intership_management_system.model.Approved;
import com.sevinc.intership_management_system.model.InternshipDocument;
import com.sevinc.intership_management_system.service.ApprovedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

import static com.sevinc.intership_management_system.util.DateFormatUtils.*;

@Component
@RequiredArgsConstructor
public class InternshipDocumentConverter {

    private final ApprovedConverter approvedConverter;
    private final ApprovedService approvedService;
    public InternshipDocument saveInternshipDocument(MultipartFile file , InternshipDocumentDTO internshipDocumentDTO){
        InternshipDocument internshipDocument = new InternshipDocument();
      // Approved approved = approvedConverter.convertApproved(internshipDocumentDTO.getApprovedId());
        ApprovedSaveDTO approvedSaveDTO = new ApprovedSaveDTO();
        approvedSaveDTO.setAssistantDean(false);
        approvedSaveDTO.setCommission(false);
        approvedSaveDTO.setHeadOfDepartment(false);
        Approved approved = approvedConverter.convertApproved(approvedSaveDTO);

        try {
            internshipDocument.setDocumentData(file.getBytes());
            internshipDocument.setDocumentName(file.getOriginalFilename());
            internshipDocument.setDocumentType(file.getContentType());
            internshipDocument.setApprovedId(approved);
            internshipDocument.setEnabled(internshipDocumentDTO.getEnabled());
            internshipDocument.setCreationDate(formatBirthdate(formatDate(new Date(), DATE)));
            internshipDocument.setFileTitleEnum(internshipDocumentDTO.getFileTitleEnum());

            return internshipDocument;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public InternshipDocumentResponseDTO convertInternshipDocumentResponse(InternshipDocument internshipDocument){
        InternshipDocumentResponseDTO internshipDocumentResponseDTO = new InternshipDocumentResponseDTO();
        ApprovedResponseDTO approvedResponseDTO = approvedConverter.convertApprovedResponse(internshipDocument.getApprovedId());
        internshipDocumentResponseDTO.setInternshipDocumentId(internshipDocument.getInternshipDocumentId());
        internshipDocumentResponseDTO.setDocumentData(internshipDocument.getDocumentData());
        internshipDocumentResponseDTO.setDocumentName(internshipDocument.getDocumentName());
        internshipDocumentResponseDTO.setDocumentType(internshipDocument.getDocumentType());
        internshipDocumentResponseDTO.setApproved(approvedResponseDTO);
        internshipDocumentResponseDTO.setEnabled(internshipDocument.getEnabled());
        internshipDocumentResponseDTO.setCreationDate(internshipDocument.getCreationDate());
        internshipDocumentResponseDTO.setFileTitleEnum(internshipDocument.getFileTitleEnum());
        return internshipDocumentResponseDTO;
     }
}
