package com.sevinc.intership_management_system.convert;

import com.sevinc.intership_management_system.dto.ApprovedResponseDTO;
import com.sevinc.intership_management_system.dto.ApprovedSaveDTO;
import com.sevinc.intership_management_system.model.Approved;
import org.springframework.stereotype.Component;

@Component
public class ApprovedConverter {

    public Approved convertApproved(ApprovedSaveDTO approvedSaveDto){
        Approved approved = new Approved();
        approved.setCommission(approvedSaveDto.getCommission());
        approved.setAssistantDean(approvedSaveDto.getAssistantDean());
        approved.setHeadOfDepartment(approvedSaveDto.getHeadOfDepartment());

        return approved;
    }

    public ApprovedResponseDTO convertApprovedResponse(Approved approved){
        ApprovedResponseDTO approvedResponseDto = new ApprovedResponseDTO();
        if (approved != null){
            approvedResponseDto.setApprovedId(approved.getApprovedId());
            approvedResponseDto.setCommission(approved.getCommission());
            approvedResponseDto.setAssistantDean(approved.getAssistantDean());
            approvedResponseDto.setHeadOfDepartment(approved.getHeadOfDepartment());

            return approvedResponseDto;
        }else{
            return null;
        }

    }
}
