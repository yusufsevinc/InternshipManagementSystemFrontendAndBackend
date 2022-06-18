package com.sevinc.intership_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "LOOK_UP_LIST")
public class LookUpList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOOK_UP_LIST_ID")
    private Long lookUpListId;

    @Column(name = "LOOK_UP_LIST_NAME")
    private String lookUpListName;

    @Column(name = "LOOK_UP_LIST_ENABLED")
    private boolean lookUpListEnabled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UNIT_ID", referencedColumnName = "UNIT_ID")
    private Unit unit;



    @OneToMany(mappedBy = "lookUpList")
    private List<LookUpListItem> lookUpListItemList;



}
