package com.example.CarExplorerBackend.repositories;

import com.example.CarExplorerBackend.models.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
}
