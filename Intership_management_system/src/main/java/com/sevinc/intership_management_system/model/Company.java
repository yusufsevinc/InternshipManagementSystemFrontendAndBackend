package com.sevinc.intership_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long companyId;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "COMPANY_PHONE")
    private String companyPhone;

    @Column(name = "COMPANY_EMAIL" , nullable = false)
    private String companyEmail;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @OneToOne(targetEntity = Address.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "COMPANY_ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address addressId;

    @OneToMany(mappedBy = "company")
    private Set<CompanyExecutive> companyExecutiveSet;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "companyId", targetEntity = Internship.class)
    private Internship internship;
}
