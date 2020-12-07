package com.example.CarExplorerBackend.repositories;

import com.example.CarExplorerBackend.models.Vehicle;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
}
