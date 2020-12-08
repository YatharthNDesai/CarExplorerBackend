package com.example.CarExplorerBackend.controllers;

import com.example.CarExplorerBackend.models.Brand;
import com.example.CarExplorerBackend.repositories.BrandRepository;
import com.example.CarExplorerBackend.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BrandController {
    @Autowired
    BrandRepository repository;

    @Autowired
    ModelRepository modelRepository;


    @GetMapping("/api/brands")
    public List<Brand> getAllBrands() {
        return (List<Brand>) repository.findAll();
    }

    @PostMapping("/api/brand")
    public Brand createBrand(@RequestBody Brand brand) {
        return repository.save(brand);
    }

    @GetMapping("api/models/{mid}")
    public Brand getBrandByModelId(@PathVariable("mid") Integer mid) {
        Integer bid = modelRepository.findById(mid).get().getBrand().getBrandId();
        return repository.findById(bid).get();
    }

    @GetMapping("/api/brands/{name}")
    public Brand getBrandByName(@PathVariable("name") String name) {
        return repository.findBrandByName(name);
    }
}
