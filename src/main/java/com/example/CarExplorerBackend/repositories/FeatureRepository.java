package com.example.CarExplorerBackend.repositories;

import com.example.CarExplorerBackend.models.Feature;
import org.springframework.data.repository.CrudRepository;

public interface FeatureRepository extends CrudRepository<Feature, Integer> {
}
