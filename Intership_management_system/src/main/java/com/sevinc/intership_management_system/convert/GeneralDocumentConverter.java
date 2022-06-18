package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.GeneralDocumentResponseDTO;
import com.sevinc.intership_management_system.dto.GeneralDocumentSaveDTO;
import com.sevinc.intership_management_system.exceptions.ServiceRuntimeException;
import com.sevinc.intership_management_system.model.GeneralDocument;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.Clock;
import java.util.Date;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class GeneralDocumentConverter {

    private  Clock clock;



    public GeneralDocument convertGeneralDocument(GeneralDocumentSaveDTO generalDocumentSaveDto){
        GeneralDocument generalDocument = new GeneralDocument();
        MultipartFile file = generalDocumentSaveDto.getFile();
        try {
            generalDocument.setDocumentData(file.getBytes());
            generalDocument.setDocumentName(file.getOriginalFilename());
            generalDocument.setDocumentType(file.getContentType());
            generalDocument.setCreationDate(new Date());

            return generalDocument;
        } catch (Exception e) {
            new ServiceRuntimeException("File type Error");
            return null;
        }
    }

    public GeneralDocumentResponseDTO convertGeneralDocumentResponse(GeneralDocument generalDocument){
        GeneralDocumentResponseDTO generalDocumentResponseDto = new GeneralDocumentResponseDTO();
        try {
            generalDocumentResponseDto.setGeneralDocumentId(generalDocument.getGeneralDocumentId());
            generalDocumentResponseDto.setDocumentData(generalDocument.getDocumentData());
            generalDocumentResponseDto.setDocumentName(generalDocument.getDocumentName());
            generalDocumentResponseDto.setDocumentType(generalDocument.getDocumentType());
            generalDocumentResponseDto.setEnabled(generalDocument.getEnabled());
            generalDocumentResponseDto.setCreationDate(generalDocument.getCreationDate());

            return generalDocumentResponseDto;
        } catch (Exception e) {
            new ServiceRuntimeException("File type Error");
            return null;
        }
    }
}
