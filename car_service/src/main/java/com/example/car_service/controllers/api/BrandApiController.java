package com.example.car_service.controllers.api;

import com.example.car_service.data.entity.Brand;
import com.example.car_service.data.service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/brand")
public class BrandApiController {

    private BrandService brandService;

    public void BrandApiController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getBrand() {
        return brandService.getBrand();
    }

    @RequestMapping("/{id}")
    public Brand getBrand(@PathVariable("id") int id) {
        return brandService.getBrand(id);
    }

    @PostMapping
    public Brand createBrand(@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBrand(@PathVariable long id) {
        brandService.deleteBrand(id);
    }
}
