package com.example.CarExplorerBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer modelId;

    @ManyToOne
    @JoinColumn(name = "brandId")
    @JsonIgnore
    private Brand brand;

    @Column(name = "modelName", unique = true)
    String modelName;
    Double modelPrice;

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @OneToMany(mappedBy = "model")
    private List<Vehicle> vehicleList;


    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Double getModelPrice() {
        return modelPrice;
    }

    public void setModelPrice(Double modelPrice) {
        this.modelPrice = modelPrice;
    }
}
