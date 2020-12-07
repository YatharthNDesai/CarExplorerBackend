package com.example.CarExplorerBackend.models;

import com.example.CarExplorerBackend.enums.Sex;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Sex getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(Sex customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Integer getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Integer customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer customerId;
    String customerName;
    Sex customerSex;
    String customerEmail;
    Integer customerPhone;


}
