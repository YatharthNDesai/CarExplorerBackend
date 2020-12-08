package com.example.CarExplorerBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer vehicleId;

    String color;
    Double vehiclePrice;


    @ManyToOne
    @JoinColumn(name = "modelId")
        @JsonIgnore
    Model model;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "vehicle_features",
            joinColumns = {@JoinColumn(name = "vehicleId")},
            inverseJoinColumns = {@JoinColumn(name = "featureId")})
    private List<Feature> featureList;

    public Double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(Double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Showroom getShowroom() {
        return showroom;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public void setShowroom(Showroom showroom) {
        this.showroom = showroom;
    }

    @ManyToOne
    @JoinColumn(name = "showroomId")
    Showroom showroom;
}
