package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class GeneralDocumentSaveDTO extends GeneralDocumentDTO {
    private MultipartFile file;

}
