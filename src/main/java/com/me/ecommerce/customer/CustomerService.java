package com.me.ecommerce.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // To get all customers
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    // To get a specific customer
    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer by id " + id + " was not found."));
    }

    // To add a new customer
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
