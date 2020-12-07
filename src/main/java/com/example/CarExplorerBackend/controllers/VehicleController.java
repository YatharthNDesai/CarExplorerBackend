package com.example.CarExplorerBackend.controllers;

import com.example.CarExplorerBackend.models.Feature;
import com.example.CarExplorerBackend.models.Vehicle;
import com.example.CarExplorerBackend.repositories.FeatureRepository;
import com.example.CarExplorerBackend.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepository repository;

    @Autowired
    FeatureRepository featureRepository;

    @GetMapping("/api/vehicles")
    public List<Vehicle> getAllVehicles() {
        return (List<Vehicle>) repository.findAll();
    }

    @PostMapping("/api/vehicle")
    public Vehicle createVehicle(@RequestBody() Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @PutMapping("/api/vehicles/{vehicleId}/features")
    public Vehicle addFeatures(@PathVariable("vehicleId") Integer vid,
                               @RequestBody() List<Feature> feature
    ) {
        System.out.println(feature);
        Vehicle vehicle = repository.findById(vid).get();
        List<Feature> featureList = vehicle.getFeatureList();
        List<Feature> featuresToAdd = new ArrayList<>();
        for (Feature f : feature) {
            featuresToAdd.add(featureRepository.findById(f.getFeatureId()).get());
        }
        featureList.addAll(featuresToAdd);
        return repository.save(vehicle);
    }
}
