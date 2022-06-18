package com.sevinc.intership_management_system.dto;

import com.sevinc.intership_management_system.model.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
public class InternshipSaveDTO {
    private int internshipDay;
    private Date startDate;
    private Date finishDate;
    private int accepted_day;
    private Date date;
    private Boolean internshipEnabled;
    private Boolean isThirdLesson;
    private CompanySaveIdDTO companySaveIdDTO;
    private AddressSaveFullIdDTO addressSaveFullIdDTO;
    private CompanyExecutiveSaveIdDTO companyExecutiveSaveIdDTO;
    private Long StudentId;
   private Long internshipDocumentId;

}
