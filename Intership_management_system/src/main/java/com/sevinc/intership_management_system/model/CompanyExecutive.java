package com.sevinc.intership_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "COMPANY_EXECUTIVE")
public class CompanyExecutive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_EXECUTIVE_ID")
    private Long companyExecutiveId;

    @Column(name = "COMPANY_EXECUTIVE_NAME")
    private String companyExecutiveName;

    @Column(name = "COMPANY_EXECUTIVE_NAME_SURNAME")
    private String companyExecutiveSurname;

    @Column(name = "COMPANY_EXECUTIVE_EMAIL")
    private String companyExecutiveEmail;

    @Column(name = "COMPANY_EXECUTIVE_PHONE")
    private String companyExecutivePhone;


    @Column(name = "COMPANY_EXECUTIVE_TITLE")
    private String companyExecutiveTitle;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID" )
    private Company company;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "companyExecutiveId", targetEntity = Internship.class)
    private Internship internship;
}
