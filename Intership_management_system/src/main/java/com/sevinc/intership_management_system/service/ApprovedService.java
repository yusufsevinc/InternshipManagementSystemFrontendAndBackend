package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.dto.ApprovedResponseDTO;
import com.sevinc.intership_management_system.dto.ApprovedSaveDTO;
import com.sevinc.intership_management_system.model.Approved;

import java.util.List;

public interface ApprovedService {
    ApprovedResponseDTO saveApproved(ApprovedSaveDTO approvedSaveDto);

    List<ApprovedResponseDTO> getAllApproved();

    ApprovedResponseDTO getByApprovedResponseDtoId(Long id);

    Approved getByApprovedId(Long id);

    boolean getDeleteApproved(Long id);

    ApprovedResponseDTO getDefaultSaveApproved();

    void update(Long approvedId, String approvedValue);
}
