package com.sevinc.intership_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "INTERNSHIP")
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTERNSHIP_ID")
    private Long internshipId;

    @Column(name = "INTERNSHIP_DAY")
    private int internshipDay;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "FINISH_DATE")
    private Date finishDate;

    @Column(name = "ACCEPTED_DAY")
    private int accepted_day;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @Column(name = "IS_THIRD_LESSON")
    private Boolean isThirdLesson;

    @ManyToOne
    @JoinColumn(name = "INTERNSHIP_DOCUMENT_ID", referencedColumnName = "INTERNSHIP_DOCUMENT_ID")
    private InternshipDocument internshipDocumentId;

    @OneToOne(targetEntity = Company.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")
    private Company companyId;

    @OneToOne(targetEntity = CompanyExecutive.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "COMPANY_EXECUTIVE_ID", referencedColumnName = "COMPANY_EXECUTIVE_ID")
    private CompanyExecutive companyExecutiveId;

    @OneToMany(mappedBy = "internshipId")
    private Set<Student> studentSet;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID")
    private Student studentId;

    @OneToOne(targetEntity = Approved.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "APPROVED_ID", referencedColumnName = "APPROVED_ID")
    private Approved approvedId;
}
