package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GeneralDocumentResponseDTO extends GeneralDocumentDTO {
    private Long generalDocumentId;
    private String documentName;
    private String documentType;
    private byte[] documentData;
    private Date creationDate;


}
