package com.example.CarExplorerBackend.repositories;

import com.example.CarExplorerBackend.models.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
    @Query("select brand from Brand brand where brand.brandName = :bname")
    public Brand findBrandByName(@Param("bname") String brandName);
}
