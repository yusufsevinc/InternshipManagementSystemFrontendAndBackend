package com.sevinc.intership_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT_IDENTITY")
public class StudentIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_IDENTITY_ID")
    private Long studentIdentityId;

    @Column(name = "FATHER_NAME")
    private String fatherName;

    @Column(name = "MOTHER_NAME")
    private String motherName;

    @Column(name = "BIRTH_PLACE")
    private String birthPlace;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "HEALTH_COVERGE")
    @Enumerated(EnumType.STRING)
    private HealthCovergeEnum healthCovergeEnum;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "studentIdentityId", targetEntity = Student.class)
    private Student student;
}
