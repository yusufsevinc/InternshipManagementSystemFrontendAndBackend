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
@Table(name = "GENERAL_DOCUMENT")
public class GeneralDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GENERAL_DOCUMENT_ID")
    private Long generalDocumentId;

    @Column(name = "GENERAL_DOCUMENT_NAME")
    private String documentName;

    @Column(name = "GENERAL_DOCUMENT_TYPE")
    private String documentType;

    @Lob
    @Column(name = "GENERAL_DOCUMENT_DATA")
    private byte[] documentData;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "ENABLED")
    private Boolean enabled;
}
