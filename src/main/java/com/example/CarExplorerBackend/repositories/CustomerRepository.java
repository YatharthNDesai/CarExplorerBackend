package com.example.CarExplorerBackend.repositories;

import com.example.CarExplorerBackend.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
