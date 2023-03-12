package com.me.ecommerce.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @DisplayName("JUnit test for getCustomers method")
    @Test
    public void shouldReturnAllCustomers() throws Exception {
        Customer customerOne = new Customer(1L, "Joe", "Biden", "joe.biden@gmail.com");
        Customer customerTwo = new Customer(2L, "Donald", "Trump", "donald.trump@gmail.com");
        given(customerService.getCustomers()).willReturn(List.of(customerOne, customerTwo));
        mockMvc.perform(get("/api/v1/customers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @DisplayName("JUnit test for getCustomer method")
    @Test
    public void shouldReturnCustomer() throws Exception {
        Customer customer = new Customer(1L, "Joe", "Biden", "joe.biden@gmail.com");
        given(customerService.getCustomer(customer.getId())).willReturn(customer);
        mockMvc.perform(get("/api/v1/customers/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @DisplayName("JUnit test for addCustomer method")
    @Test
    public void shouldAddCustomer() throws Exception {
        Customer customer = new Customer(1L, "Joe", "Biden", "joe.biden@gmail.com");
        given(customerService.addCustomer(customer)).willReturn(customer);
        mockMvc.perform(post("/api/v1/customers")
                        .param("id", customer.getId().toString())
                        .param("name", customer.getName())
                        .param("surname", customer.getSurname())
                        .param("email", customer.getEmail()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
