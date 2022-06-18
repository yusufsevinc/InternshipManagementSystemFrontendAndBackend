package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.dto.DistrictResponseDTO;
import com.sevinc.intership_management_system.dto.NeighborhoodResponseDTO;
import com.sevinc.intership_management_system.dto.NeighborhoodSaveDTO;
import com.sevinc.intership_management_system.dto.NeighborhoodSaveIdDTO;
import com.sevinc.intership_management_system.service.NeighborhoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("neighborhood")
@RequiredArgsConstructor
@CrossOrigin
public class NeighborhoodController {

    private final NeighborhoodService neighborhoodService;

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("save")
    public NeighborhoodResponseDTO saveNeighborhood(@RequestBody NeighborhoodSaveDTO neighborhoodSaveDto) {
        return neighborhoodService.saveNeighborhood(neighborhoodSaveDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("id-with-save")
    public NeighborhoodResponseDTO saveNeighborhood(@RequestBody NeighborhoodSaveIdDTO neighborhoodSaveIdDto) {
        return neighborhoodService.saveNeighborhood(neighborhoodSaveIdDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("all")
    public List<NeighborhoodResponseDTO> neighborhoodAll() {
        return neighborhoodService.getAllNeighborhood();
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("{id}")
    public NeighborhoodResponseDTO getByNeighborhoodId(@PathVariable("id") Long id) {
        return neighborhoodService.getByNeighborhoodDtoId(id);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("neighborhood-district/{id}")
    public List<NeighborhoodResponseDTO> getNeighborhoodDistrictAll(@PathVariable("id") Long id) {
        return neighborhoodService.getAllDistrictNeighborhood(id);
    }
}
