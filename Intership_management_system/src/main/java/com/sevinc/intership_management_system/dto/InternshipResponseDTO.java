package com.sevinc.intership_management_system.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InternshipResponseDTO {

    private Long internshipId;
    private int internshipDay;
    private String startDate;
    private String finishDate;
    private int accepted_day;
    private Date date;
    private Boolean internshipEnabled;
    private Boolean isThirdLesson;
    private CompanyResponseDTO companyResponseDTO;
    private CompanyExecutiveResponseDTO companyExecutiveResponseDTO;
    private Long StudentId;
    private Long internshipDocumentId;
    private ApprovedResponseDTO approvedResponseDTO;
}
