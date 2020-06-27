package com.zorin.petclinic.model;

import java.io.Serializable;

/**
 * Created by Chintu on 6/23/2020
 */
public class Speciality extends BaseEntity implements Serializable {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
