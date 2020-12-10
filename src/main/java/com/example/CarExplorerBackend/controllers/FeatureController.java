package com.example.CarExplorerBackend.controllers;

import com.example.CarExplorerBackend.models.Feature;
import com.example.CarExplorerBackend.repositories.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FeatureController {

    @Autowired
    FeatureRepository repository;

    @GetMapping("/api/features")
    public List<Feature> getAllFeatures() {
        return (List<Feature>) repository.findAll();
    }

    @PostMapping("/api/features")
    public Feature createFeature(@RequestBody() Feature feature) {
        return repository.save(feature);
    }

    @DeleteMapping("/api/features/{featureId}")
    public int deleteFeature (@PathVariable("featureId") Integer featureId) {
        repository.deleteById(featureId);
        return 1;
    }
}
