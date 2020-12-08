package com.example.CarExplorerBackend.repositories;

import com.example.CarExplorerBackend.models.Brand;
import com.example.CarExplorerBackend.models.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ModelRepository extends CrudRepository<Model, Integer> {
    @Query("select model.modelName from Model model join Vehicle vehicle on model.modelId = :vid")
    public String findModelByVehicleId(@Param("vid") Integer vehicleId);
}
