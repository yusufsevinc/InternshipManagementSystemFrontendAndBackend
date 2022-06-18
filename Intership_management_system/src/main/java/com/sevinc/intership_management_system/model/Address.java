package com.sevinc.intership_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Long addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NEIGHBORHOOD_KEY", referencedColumnName = "NEIGHBORHOOD_ID" , nullable = false)
    private Neighborhood neighborhoodId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DISTRICT_KEY", referencedColumnName = "DISTRICT_ID")
    private District districtId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CITY_KEY", referencedColumnName = "CITY_ID")
    private City cityId;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @Column(name = "APARTMENT_NO")
    private String apartmentNo;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "addressId", targetEntity = Company.class)
    private Company company;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "addressId", targetEntity = Student.class)
    private Student student;
}
