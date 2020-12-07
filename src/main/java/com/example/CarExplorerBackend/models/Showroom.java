package com.example.CarExplorerBackend.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "showroom")
public class Showroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer showroomId;
    String showroomName;
    String Address;

    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff staff) {
        this.manager = staff;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            uniqueConstraints=
            @UniqueConstraint(columnNames={"showroomId", "staffId"}),
            name = "manager",
            joinColumns = {@JoinColumn(name = "showroomId")},
            inverseJoinColumns = {@JoinColumn(name = "staffId")})
    private Staff manager;

    @OneToMany(mappedBy = "showroom")
    List<Staff> staffList;

    public Integer getShowroomId() {
        return showroomId;
    }

    public void setShowroomId(Integer showroomId) {
        this.showroomId = showroomId;
    }

    public String getShowroomName() {
        return showroomName;
    }

    public void setShowroomName(String showroomName) {
        this.showroomName = showroomName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
}
