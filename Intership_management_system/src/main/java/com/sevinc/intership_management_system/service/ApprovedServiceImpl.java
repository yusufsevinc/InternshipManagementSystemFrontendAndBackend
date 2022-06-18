package com.sevinc.intership_management_system.service;

import com.sevinc.intership_management_system.convert.ApprovedConverter;
import com.sevinc.intership_management_system.dto.ApprovedResponseDTO;
import com.sevinc.intership_management_system.dto.ApprovedSaveDTO;
import com.sevinc.intership_management_system.exceptions.ServiceRuntimeException;
import com.sevinc.intership_management_system.model.Approved;
import com.sevinc.intership_management_system.repository.ApprovedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApprovedServiceImpl implements ApprovedService {

    private final ApprovedConverter approvedConverter;
    private final ApprovedRepository approvedRepository;

    @Override
    @Transactional
    public ApprovedResponseDTO saveApproved(ApprovedSaveDTO approvedSaveDto){
        Approved approved = approvedConverter.convertApproved(approvedSaveDto);
        approved = approvedRepository.save(approved);
        return approvedConverter.convertApprovedResponse(approved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApprovedResponseDTO> getAllApproved(){
        List<Approved> approvedList = approvedRepository.findAll();
        return approvedList.stream()
                .map(approved -> approvedConverter.convertApprovedResponse(approved))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ApprovedResponseDTO getByApprovedResponseDtoId(Long id){
        final  var approved = approvedRepository.findById(id)
                .orElseThrow(() -> new ServiceRuntimeException("Approved Not Found"));
        ApprovedResponseDTO approvedResponseDto = approvedConverter.convertApprovedResponse(approved);
        return approvedResponseDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Approved getByApprovedId(Long id){
        final  var approved = approvedRepository.findById(id)
                .orElseThrow(() -> new ServiceRuntimeException("Approved Not Found"));
        return approved;
    }

    @Override
    @Transactional
    public boolean getDeleteApproved(Long id){
        Approved approved = getByApprovedId(id);
        if (approved.getApprovedId() == id){
            approvedRepository.deleteApprovedByApprovedId(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional
    public ApprovedResponseDTO getDefaultSaveApproved(){
        Approved approved = new Approved();
        approved.setCommission(false);
        approved.setAssistantDean(false);
        approved.setHeadOfDepartment(false);
        approved = approvedRepository.save(approved);
        return approvedConverter.convertApprovedResponse(approved);

    }
    @Override
    @Transactional
    public void update(Long approvedId,String approvedValue){
        String approvedType = approvedValue;
        switch (approvedType) {
            case "commission":
                approvedRepository.updateCommission(approvedId);
                break;
            case "assistantDean":
                approvedRepository.updateAssistantDean(approvedId);
                break;
            case "headOfDepartment":
                approvedRepository.updateHeadOfDepartment(approvedId);
                break;
        }
    }
}
