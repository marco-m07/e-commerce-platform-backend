package com.me.ecommerce.customer;

import jakarta.persistence.*;

/**
 * This class defines a Customer of the E-Commerce platform.
 */

@Table
@Entity(name="Customer")
public class Customer {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String email;

    // Constructor
    public Customer() {}

    public Customer(Long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Instance methods
    @Override
    public String toString() {
        return String.join("_",
                String.valueOf(id),
                name,
                surname,
                email);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + id.hashCode();
        hash = 31 * hash + name.hashCode();
        hash = 31 * hash + surname.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) obj;
        return customer.id.equals(id) &&
                customer.name.equals(name) &&
                customer.surname.equals(surname);
    }
}
