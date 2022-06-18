package com.sevinc.intership_management_system.dto;

import com.sevinc.intership_management_system.model.FileTitleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternshipDocumentDTO {
    private FileTitleEnum fileTitleEnum;
    private Boolean enabled;
    private ApprovedSaveDTO approvedId;
}
