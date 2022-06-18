package com.sevinc.intership_management_system.repository;

import com.sevinc.intership_management_system.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Long> {

    Optional<District> findDistrictByDistrictId(Long districtId);

    Optional<District> findDistrictByDistrictKey(Long districtKey);

    List<District> findDistrictByCity_CityKey(Long cityKey);
}
