package com.me.ecommerce.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class CustomerServiceTests {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService underTest;

    @DisplayName("JUnit test for addCustomer method")
    @Test
    void shouldAddNewCustomer() {
        // given
        Customer customer = new Customer(1L, "Joe", "Biden", "joe.biden@gmail.com");
        given(customerRepository.save(any(Customer.class))).willReturn(customer);

        // when
        Customer registeredCustomer = underTest.addCustomer(customer);

        // then
        assertThat(registeredCustomer.getId()).isEqualTo(customer.getId());
    }

    @DisplayName("JUnit test for getCustomers method")
    @Test
    void shouldReturnAllCustomers() {
        // given
        Customer customerOne = new Customer(1L, "Joe", "Biden", "joe.biden@gmail.com");
        Customer customerTwo = new Customer(2L, "Donald", "Trump", "donald.trump@gmail.com");
        given(customerRepository.findAll()).willReturn(List.of(customerOne, customerTwo));

        // when
        List<Customer> customers = underTest.getCustomers();

        // then
        assertThat(customers.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getCustomer method")
    @Test
    void shouldRaiseExceptionForNonExistingCustomer() {
        // given
        Customer customer = new Customer(1L, "Joe", "Biden", "joe.biden@gmail.com");
        given(customerRepository.findById(customer.getId())).willReturn(Optional.empty());

        // when
        Exception exception = assertThrows(RuntimeException.class, () -> underTest.getCustomer(customer.getId()));

        // then
        assertEquals("Customer by id " + customer.getId() + " was not found.", exception.getMessage());
    }
}
