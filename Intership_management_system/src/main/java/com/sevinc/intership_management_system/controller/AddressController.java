package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.dto.AddressResponseDTO;
import com.sevinc.intership_management_system.dto.AddressSaveDTO;
import com.sevinc.intership_management_system.dto.AddressSaveFullIdDTO;
import com.sevinc.intership_management_system.dto.AddressSaveIdDTO;
import com.sevinc.intership_management_system.service.AddressService;
import com.sevinc.intership_management_system.service.AddressServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
@CrossOrigin
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("save")
    public AddressResponseDTO saveAddress(@RequestBody AddressSaveDTO addressSaveDto) {
        return addressService.saveAddress(addressSaveDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping ("save-id")
    AddressResponseDTO saveAddress(@RequestBody AddressSaveFullIdDTO addressSaveFullIdDTO){
        return addressService.saveAddress(addressSaveFullIdDTO);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @PostMapping("id-with-save")
    public AddressResponseDTO saveAddress(@RequestBody AddressSaveIdDTO addressSaveIdDto) {
        return addressService.saveAddress(addressSaveIdDto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("all")
    public List<AddressResponseDTO> addressAll() {
        return addressService.getAllAddress();
    }

    @PreAuthorize("hasAnyRole('STUDENT','COMMISSION','HEAD_OF_DEPARTMENT','DEAN','SECRETARY')")
    @GetMapping("{id}")
    public AddressResponseDTO getByAddressId(@PathVariable("id") Long id) {
        return addressService.getByAddressResponseDtoId(id);
    }
}
