package com.example.car_service.data.entity;

import javax.persistence.*;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBrands;
    private String name;


    public Brand(long idBrands, String name) {
        this.idBrands = idBrands;
        this.name = name;

    }

    public Brand() {
    }

    public long getIdBrands() {
        return idBrands;
    }

    public void setIdBrands(long idBrands) {
        this.idBrands = idBrands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}