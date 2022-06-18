package com.sevinc.intership_management_system.repository;

import com.sevinc.intership_management_system.model.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {

    List<Neighborhood> findNeighborhoodByDistrict_DistrictKey(Long districtKey);

    Optional<Neighborhood> findNeighborhoodByNeighborhoodKey(Long neighborhood);
}
