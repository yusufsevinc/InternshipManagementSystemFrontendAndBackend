package com.sevinc.intership_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "APPROVED")
public class Approved {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APPROVED_ID")
    private Long approvedId;

    @Column(name = "COMMISSION")
    private Boolean commission;

    @Column(name = "ASSISTANT_DEAN")
    private Boolean assistantDean;

    @Column(name = "HEAD_OF_DEPARTMENT")
    private Boolean headOfDepartment;

    @OneToOne(mappedBy = "approvedId")
    private InternshipDocument internshipDocument;

    @OneToOne(mappedBy = "approvedId")
    private Internship internship;
}
