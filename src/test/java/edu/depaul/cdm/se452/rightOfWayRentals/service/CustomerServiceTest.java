package edu.depaul.cdm.se452.rightOfWayRentals.service;

import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.rightOfWayRentals.data.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock CustomerRepository customerRepository;
    CustomerService service;

    @BeforeEach
    void setupService() {
        service = new CustomerService(customerRepository);
    }

    @Test
    void testGetCustomerById() {
        final Long customerId = 1L;
        final Customer expected = new Customer(customerId, "Robert Millins", Collections.emptyList());

        when(customerRepository.findById(customerId))
                .thenReturn(Optional.of(expected));

        final Customer actual = service.getCustomerById(customerId);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testGetCustomerByIdWhenNoneReturned() {
        final Long customerId = 0L;
        when(customerRepository.findById(customerId))
                .thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class, () -> service.getCustomerById(customerId));
    }

    @Test
    void testGetAllCustomers() {
        final Customer customer_1 = new Customer(1, "Wendy", Collections.emptyList());
        final Customer customer_2 = new Customer(2, "Jerry", Collections.emptyList());
        List<Customer> expected = Arrays.asList(customer_1, customer_2);
        when(customerRepository.findAll()).thenReturn(expected);

        assertThat(service.getAllCustomers())
                .isEqualTo(expected);
    }

    @Test
    void testGetAllCustomersWhenNoneExist() {
        final List<Customer> expected = Collections.emptyList();
        when(customerRepository.findAll()).thenReturn(expected);
        assertThat(service.getAllCustomers()).isEqualTo(expected);
    }

    @Test
    void testCreateCustomer() {
        final String customer_name = "Ginger";
        final Customer expected = new Customer(customer_name);
        when(customerRepository.save(any(Customer.class))).thenReturn(expected);
        assertThat(service.createCustomer(customer_name))
                .isEqualTo(expected);
    }




}