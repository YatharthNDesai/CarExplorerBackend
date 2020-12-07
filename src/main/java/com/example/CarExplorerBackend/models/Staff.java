package com.example.CarExplorerBackend.models;


import com.example.CarExplorerBackend.enums.Sex;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer staffId;
    String staffName;
    Boolean isManager;

    @ManyToOne
    @JoinColumn(name = "showroomId")
            @JsonIgnore
    Showroom showroom;

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Sex getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(Sex staffSex) {
        this.staffSex = staffSex;
    }

    public Showroom getShowroom() {
        return showroom;
    }

    public void setShowroom(Showroom showroom) {
        this.showroom = showroom;
    }

    Sex staffSex;

}
