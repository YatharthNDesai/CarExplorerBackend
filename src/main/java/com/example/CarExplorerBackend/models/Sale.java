package com.example.CarExplorerBackend.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sale")
public class Sale implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Integer saleId;

    @ManyToOne
    @JoinColumn(name = "showroomId")
    Showroom showroom;

    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;

    @Id
    @OneToOne
    @MapsId("vehicleId")
    Vehicle vehicle;

//    public Integer getSaleId() {
//        return saleId;
//    }
//
//    public void setSaleId(Integer saleId) {
//        this.saleId = saleId;
//    }

    public Showroom getShowroom() {
        return showroom;
    }

    public void setShowroom(Showroom showroom) {
        this.showroom = showroom;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
