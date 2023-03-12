package com.me.ecommerce.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // To retrieve all customers
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    // To retrieve a specific customer
    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    // To add new customer
    @PostMapping
    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }
}
