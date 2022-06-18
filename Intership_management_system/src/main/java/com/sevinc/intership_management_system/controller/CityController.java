package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.dto.CityResponseDTO;
import com.sevinc.intership_management_system.dto.CitySaveDTO;
import com.sevinc.intership_management_system.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("city")
@RequiredArgsConstructor
@CrossOrigin
public class CityController {

    private final CityService cityService;
    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("save")
    public CityResponseDTO saveCity(@RequestBody CitySaveDTO citySaveDto) {
        return cityService.saveCity(citySaveDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("all")
    public List<CityResponseDTO> cityAll() {
        return cityService.getAllCity();
    }
    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("{id}")
    public CityResponseDTO getByCityId(@PathVariable("id") Long id) {
        return cityService.getByCityResponseDtoId(id);
    }
}
