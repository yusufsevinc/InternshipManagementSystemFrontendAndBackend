package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.dto.GeneralDocumentResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface GeneralDocumentService {
    GeneralDocumentResponseDTO save(MultipartFile multipartFile , Boolean state);
}
