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
@Table(name = "PERSON")
@PrimaryKeyJoinColumn(name = "PERSON_ID", referencedColumnName = "USER_ID")
public class Person extends User {

    @Column(name = "PERSON_NAME")
    private String person_name;

    @Column(name = "PERSON_SURNAME")
    private String person_surname;

    @OneToOne(targetEntity = LookUpListItem.class, optional = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "POSITION_ID", referencedColumnName = "LOOK_UP_LIST_ITEM_ID")
    private LookUpListItem positionId;

    @OneToOne(targetEntity = LookUpListItem.class, optional = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "TITLE_ID", referencedColumnName = "LOOK_UP_LIST_ITEM_ID")
    private LookUpListItem titleId;

    @OneToOne(targetEntity = Unit.class, optional = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "UNIT_ID", referencedColumnName = "UNIT_ID")
    private Unit unitId;

    @OneToMany(mappedBy = "personId")
    private Set<Transaction> setTransaction;
}
