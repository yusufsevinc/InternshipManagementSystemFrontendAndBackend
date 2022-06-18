package com.sevinc.intership_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "UNIT")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIT_ID")
    private Long unitId;

    @Column(name = "UNIT_NAME")
    private String unitName;

    @Column(name = "UNIT_ENABLED")
    private Boolean unitEnabled;

    @Column(name = "PARENT_ID")
    private Long parentId;

    @OneToMany(mappedBy = "unit")
    private List<LookUpList> lookUpLists;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "unitId", targetEntity = Person.class)
    private Person personTitle;


}
