package com.example.car_service.data.service;

import com.example.car_service.data.entity.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getBrand();

    Brand getBrand(long id);

    Brand createBrand(Brand brand);

    void deleteBrand(long id);
}
