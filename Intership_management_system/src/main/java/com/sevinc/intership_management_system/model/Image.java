package com.sevinc.intership_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "IMAGE")
public class Image {

    @Id
    @Column(name = "IMAGE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(name = "IMAGE_TYPE")
    private String imageType;

    @Column(name = "PICTURE_TYPE", length = 1000)
    private byte[] pictureType;

    @OneToOne(mappedBy = "imageId")
    private Student student;
}