package com.sevinc.intership_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "NEIGHBORHOOD")
public class Neighborhood implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NEIGHBORHOOD_ID")
    private Long neighborhoodId;

    @Column(name = "NEIGHBORHOOD_NAME")
    private String neighborhoodName;

    @Column(name = "NEIGHBORHOOD_KEY")
    private Long neighborhoodKey;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DISTRICT_KEY", nullable = false ,referencedColumnName = "DISTRICT_KEY")
    private District district;


    @OneToMany(mappedBy = "neighborhoodId")
    private List<Address> address;
}
