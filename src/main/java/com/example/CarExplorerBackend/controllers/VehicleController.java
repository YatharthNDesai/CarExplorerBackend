package com.example.CarExplorerBackend.controllers;

import com.example.CarExplorerBackend.models.*;
import com.example.CarExplorerBackend.repositories.FeatureRepository;
import com.example.CarExplorerBackend.repositories.ModelRepository;
import com.example.CarExplorerBackend.repositories.ShowroomRepository;
import com.example.CarExplorerBackend.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEventHttpMessageWriter;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    VehicleRepository repository;

    @Autowired
    FeatureRepository featureRepository;

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    ShowroomRepository showroomRepository;

    @GetMapping("/api/vehicles")
    public List<Vehicle> getAllVehicles() {
        return (List<Vehicle>) repository.findAll();
    }

    @PostMapping("/api/showrooms/{showroomId}/models/{modelId}/vehicles")
    public Vehicle createVehicleByShowroom(@PathVariable("showroomId") Integer sid,
                                           @PathVariable("modelId") Integer mid,
                                           @RequestBody() Vehicle vehicle) {
        Showroom showroom = showroomRepository.findById(sid).get();
        Model model = modelRepository.findById(mid).get();
        vehicle.setShowroom(showroom);
        vehicle.setModel(model);
        vehicle.setFeatureList(vehicle.getFeatureList());
        return repository.save(vehicle);
    }

    @PostMapping("/api/models/{modelId}/vehicles")
    public Vehicle createVehicle(
            @PathVariable("modelId") Integer mid,
            @RequestBody() Vehicle vehicle) {

        Model model = modelRepository.findById(mid).get();

        vehicle.setModel(model);
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

    @DeleteMapping("/api/vehicles/{vehicleId}")
    public int deleteVehicle(@PathVariable("vehicleId") Integer vid) {
        repository.deleteById(vid);
        return 1;

    }

    @GetMapping("/api/vehicles/{vehicleId}/features")
    public List<Feature> getFeaturesForVehicle(@PathVariable("vehicleId") Integer vehicleId) {
        return repository.findById(vehicleId).get().getFeatureList();
    }

}
