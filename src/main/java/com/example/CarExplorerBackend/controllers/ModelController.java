package com.example.CarExplorerBackend.controllers;

import com.example.CarExplorerBackend.models.Brand;
import com.example.CarExplorerBackend.models.Model;
import com.example.CarExplorerBackend.models.Vehicle;
import com.example.CarExplorerBackend.repositories.BrandRepository;
import com.example.CarExplorerBackend.repositories.ModelRepository;
import com.example.CarExplorerBackend.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ModelController {

    @Autowired
    ModelRepository repository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/api/models")
    public List<Model> getAllModels() {
        return (List<Model>) repository.findAll();
    }

    @GetMapping("/api/vehicles/{vid}")
    public Model getModelbyVehicleId(@PathVariable("vid") Integer vid) {
        Integer mid = vehicleRepository.findById(vid).get().getModel().getModelId();
        return repository.findById(mid).get();
    }

    @PostMapping("/api/brands/{brandId}/models")
    public Model createModel(@PathVariable("brandId") Integer bid,
                             @RequestBody() Model model) {
        Brand brand = brandRepository.findById(bid).get();
        model.setBrand(brand);
        return repository.save(model);
    }

    @DeleteMapping("/api/models/{modelId}")
    public int deleteModel(@PathVariable("modelId") Integer modelId) {
        repository.deleteById(modelId);
        return 1;
    }

    @GetMapping("/api/models/{modelId}/vehicles")
    public List<Vehicle> getVehiclesForModel(@PathVariable("modelId") Integer mid) {
        return repository.findById(mid).get().getVehicleList();
    }
}
