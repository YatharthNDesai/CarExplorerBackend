//package com.example.CarExplorerBackend.models;
//
//import javax.persistence.*;
//import javax.persistence.criteria.CriteriaBuilder;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "manager")
//public class Manager implements Serializable {
//    public Staff getStaff() {
//        return staff;
//    }
//
//    public void setStaff(Staff staff) {
//        this.staff = staff;
//    }
//
//    public Showroom getShowroom() {
//        return showroom;
//    }
//
//    public void setShowroom(Showroom showroom) {
//        this.showroom = showroom;
//    }
//
//    @Id
//    @OneToOne
//    @MapsId("staffId")
//    Staff staff;
//
//    @OneToOne
//    @JoinColumn(name = "showroomId")
//    Showroom showroom;
//
//}
