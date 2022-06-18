package com.sevinc.intership_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDENT")
@PrimaryKeyJoinColumn(name = "STUDENT_ID", referencedColumnName = "USER_ID")
public class Student extends User {

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @Column(name = "SCHOOL_NUMBER")
    private String schoolNumber;

    @Column(name = "level")
    private String level;

    @OneToOne(targetEntity = LookUpListItem.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "STUDENT_DEPARTMENT_ID", referencedColumnName = "LOOK_UP_LIST_ITEM_ID")
    private LookUpListItem studentDepartmentId;

    @OneToOne(targetEntity = StudentIdentity.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "STUDENT_IDENTITY_ID", referencedColumnName = "STUDENT_IDENTITY_ID")
    private StudentIdentity studentIdentityId;

    @OneToOne(targetEntity = Address.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address addressId;

    @OneToOne(targetEntity = Image.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "IMAGE_ID", referencedColumnName = "IMAGE_ID")
    private Image imageId;

    @OneToMany(mappedBy = "studentId")
    private Set<Internship> internships;

    @ManyToOne
    @JoinColumn(name = "INTERNSHIP_ID", referencedColumnName = "INTERNSHIP_ID")
    private Internship internshipId;

    @OneToMany(mappedBy = "studentId")
    private Set<InternshipDocument> ınternshipDocumentSet;


}
