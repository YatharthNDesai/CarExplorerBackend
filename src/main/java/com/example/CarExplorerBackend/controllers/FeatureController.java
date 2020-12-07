package com.example.CarExplorerBackend.controllers;

import com.example.CarExplorerBackend.models.Feature;
import com.example.CarExplorerBackend.repositories.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeatureController {

    @Autowired
    FeatureRepository repository;

    @GetMapping("/api/features")
    public List<Feature> getAllFeatures() {
        return (List<Feature>) repository.findAll();
    }

    @PostMapping("/api/feature")
    public void createFeature(@RequestBody() Feature feature) {
        repository.save(feature);
    }
}