package com.example.CarExplorerBackend.repositories;

import com.example.CarExplorerBackend.models.Model;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model, Integer> {
}
