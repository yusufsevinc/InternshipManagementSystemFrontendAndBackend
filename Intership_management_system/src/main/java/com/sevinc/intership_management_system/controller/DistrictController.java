package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.dto.DistrictResponseDTO;
import com.sevinc.intership_management_system.dto.DistrictSaveDTO;
import com.sevinc.intership_management_system.dto.DistrictSaveIdDTO;
import com.sevinc.intership_management_system.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/district")
@RequiredArgsConstructor
@CrossOrigin
public class DistrictController {

    private final DistrictService districtService;

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("/save")
    public DistrictResponseDTO saveDistrict(@RequestBody DistrictSaveDTO districtSaveDto) {
        return districtService.saveDistrict(districtSaveDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("id-with-save")
    public DistrictResponseDTO saveDistrict(@RequestBody DistrictSaveIdDTO districtSaveDto) {
        return districtService.saveDistrict(districtSaveDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("/{id}")
    public DistrictResponseDTO getByDistrictId(@PathVariable("id") Long id) {
        return districtService.getByDistrictDtoId(id);
    }
    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("/all")
    public List<DistrictResponseDTO> districtAll() {
        return districtService.getAllDistrict();
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("district-city/{id}")
    public List<DistrictResponseDTO> districtCityAll(@PathVariable("id") Long id) {
        return districtService.getAllCityDistrict(id);
    }

}
