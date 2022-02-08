package com.example.car_service.data.entity;

import javax.persistence.*;

@Entity
public class AutoService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;

    public AutoService(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public AutoService(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}