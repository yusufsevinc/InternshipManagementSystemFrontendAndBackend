package com.sevinc.intership_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INTERNSHIP_DOCUMENT")
public class InternshipDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTERNSHIP_DOCUMENT_ID")
    private Long internshipDocumentId;

    @Column(name = "INTERNSHIP_DOCUMENT_NAME" , nullable = false)
    private String documentName;

    @Column(name = "INTERNSHIP_DOCUMENT_TYPE")
    private String documentType;

    @Lob
    @Column(name = "INTERNSHIP_DOCUMENT_DATA")
    private byte[] documentData;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "TITLE",nullable = false)
    @Enumerated(EnumType.STRING)
    private FileTitleEnum fileTitleEnum;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @OneToOne(targetEntity = Approved.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "APPROVED_ID", referencedColumnName = "APPROVED_ID")
    private Approved approvedId;

    @OneToMany(mappedBy = "internshipDocumentId")
    private Set<InternshipDocument> internshipDocumentSet;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID" )
    private Student studentId;
}
