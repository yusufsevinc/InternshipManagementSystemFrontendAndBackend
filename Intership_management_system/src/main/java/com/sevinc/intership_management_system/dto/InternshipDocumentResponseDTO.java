package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InternshipDocumentResponseDTO extends InternshipDocumentDTO{
    private Long internshipDocumentId;
    private String documentName;
    private String documentType;
    private byte[] documentData;
    private Date creationDate;
    private ApprovedResponseDTO approved;
}
