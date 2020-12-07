package com.example.CarExplorerBackend.controllers;


import com.example.CarExplorerBackend.models.Customer;
import com.example.CarExplorerBackend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers() {
        return (List<Customer>) repository.findAll();
    }

    @GetMapping("/api/customers/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable("customerId") Integer cid) {
        return repository.findById(cid);
    }

    @PostMapping("api/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @PutMapping("api/customers/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") Integer cid,
                                   @RequestBody Customer customer) {
        Customer customerToUpdate = repository.findById(cid).get();
        customerToUpdate.setCustomerEmail(customer.getCustomerEmail() != null ? customer.getCustomerEmail() : customerToUpdate.getCustomerEmail());
        customerToUpdate.setCustomerName(customer.getCustomerName() != null ? customer.getCustomerName() : customerToUpdate.getCustomerName());
        customerToUpdate.setCustomerPhone(customer.getCustomerPhone() != null ? customer.getCustomerPhone() : customerToUpdate.getCustomerPhone());
        customerToUpdate.setCustomerSex(customer.getCustomerSex() != null ? customer.getCustomerSex() : customerToUpdate.getCustomerSex());
        return repository.save(customerToUpdate);
    }

    @DeleteMapping("api/customers/{customerId}")
    public int deleteCustomer(@PathVariable("customerId") Integer cid) {
        repository.deleteById(cid);
        return 0;
    }
}
