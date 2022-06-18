package com.sevinc.intership_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "DISTRICT")
public class District implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISTRICT_ID")
    private Long districtId;

    @Column(name = "DISTRICT_NAME")
    private String districtName;

    @Column(name = "DISTRICT_KEY")
    private Long districtKey;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CITY_KEY", nullable = false , referencedColumnName = "CITY_KEY")
    private City city;

    @OneToMany(mappedBy = "district")
    private List<Neighborhood> neighborhoodList;

    @OneToMany(mappedBy = "districtId")
    private List<Address> address;
}
