package edu.depaul.cdm.se452.RightOfWayRentals.service;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomerById(final Long customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }

    public List<Customer> getAllCustomers() {
        final List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer createCustomer(final String name) {
        return Optional.ofNullable(name)
                .map(Customer::new)
                .map(customerRepository::save)
                .orElseThrow();
    }


}
