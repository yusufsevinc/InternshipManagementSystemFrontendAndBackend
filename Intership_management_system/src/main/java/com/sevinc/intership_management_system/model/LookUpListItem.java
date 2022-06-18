package com.sevinc.intership_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "LOOK_UP_LIST_ITEM")
public class LookUpListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOOK_UP_LIST_ITEM_ID")
    private Long lookUpListItemId;

    @Column(name = "LOOK_UP_LIST_ITEM_NAME")
    private String lookUpListItemName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOOK_UP_LIST_ID", referencedColumnName = "LOOK_UP_LIST_ID")
    private LookUpList lookUpList;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "positionId", targetEntity = Person.class)
    private Person personPosition;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "titleId", targetEntity = Person.class)
    private Person personTitle;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "studentDepartmentId", targetEntity = Student.class)
    private Student student;
}
