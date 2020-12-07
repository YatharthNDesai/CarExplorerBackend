package com.example.CarExplorerBackend.controllers;

import com.example.CarExplorerBackend.models.Brand;
import com.example.CarExplorerBackend.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    BrandRepository repository;

    @GetMapping("/api/brands")
    public List<Brand> getAllBrands() {
        return (List<Brand>) repository.findAll();
    }

    @PostMapping("/api/brand")
    public Brand createBrand(@RequestBody Brand brand){
        return repository.save(brand);
    }
}
