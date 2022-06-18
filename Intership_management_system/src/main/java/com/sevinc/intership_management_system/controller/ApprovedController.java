package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.dto.ApprovedResponseDTO;
import com.sevinc.intership_management_system.dto.ApprovedSaveDTO;
import com.sevinc.intership_management_system.service.ApprovedService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("approved")
@RequiredArgsConstructor
@CrossOrigin
public class ApprovedController {

    private final ApprovedService approvedService;

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("save")
    public ApprovedResponseDTO save(@RequestBody ApprovedSaveDTO approvedSaveDto){
        return approvedService.saveApproved(approvedSaveDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("all")
    public List<ApprovedResponseDTO> approvedAll(){
        return approvedService.getAllApproved();
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("{id}")
    public ApprovedResponseDTO getByApprovedId(@PathVariable("id") Long id){
        return approvedService.getByApprovedResponseDtoId(id);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @DeleteMapping("delete/{id}")
    public boolean approvedDelete(@PathVariable("id") Long id){
        return approvedService.getDeleteApproved(id);
    }


    @PreAuthorize("hasAnyRole('COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PutMapping("update/{type}/{id}")
    public void approvedUpdate(@PathVariable("type") String type ,@PathVariable("id") Long id){
        approvedService.update(id,type);
    }


}
