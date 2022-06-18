package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.convert.GeneralDocumentConverter;
import com.sevinc.intership_management_system.dto.GeneralDocumentResponseDTO;
import com.sevinc.intership_management_system.model.GeneralDocument;
import com.sevinc.intership_management_system.repository.GeneralDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class GeneralDocumentServiceImpl implements GeneralDocumentService{

    private final GeneralDocumentRepository generalDocumentRepository;
    private final GeneralDocumentConverter generalDocumentConverter;

    @Override
    @Transactional
    public GeneralDocumentResponseDTO save(MultipartFile multipartFile , Boolean state) {
      GeneralDocument generalDocument = new GeneralDocument();
        try {
            generalDocument.setDocumentData(multipartFile.getBytes());
            generalDocument.setDocumentType(multipartFile.getContentType());
            generalDocument.setDocumentName(multipartFile.getOriginalFilename());
            generalDocument.setCreationDate(new Date());
            generalDocument.setEnabled(state);

            generalDocument = generalDocumentRepository.save(generalDocument);

            return generalDocumentConverter.convertGeneralDocumentResponse(generalDocument);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
