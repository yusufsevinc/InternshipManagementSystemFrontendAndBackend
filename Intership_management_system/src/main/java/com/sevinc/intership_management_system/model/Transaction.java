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
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @Column(name = "TRANSACTION_MESSAGE")
    private String transactionMessage;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;

    @Column(name = "MODIFIED_ON")
    private Date modifiedOn;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_PERSON_ID", referencedColumnName = "PERSON_ID")
    private Person personId;
}
