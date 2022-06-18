package com.sevinc.intership_management_system.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CITY")
@CrossOrigin
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITY_ID")
    private Long cityId;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "CITY_KEY")
    private Long cityKey;

    @OneToMany(mappedBy = "cityId")
    private List<Address> address;
}
