package com.example.car_service.data.repository;

import com.example.car_service.data.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {}

