package edu.depaul.cdm.se452.RightOfWayRentals.service;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * TODO
     * @param customerId
     * @return
     */
    public Customer getCustomerById(final Long customerId) {
        log.trace("Querying customer repository with ID : {}", customerId);
        return customerRepository.findById(customerId).orElseThrow();
    }

    /**
     * TODO
     * @return
     */
    public List<Customer> getAllCustomers() {
        log.trace("Attempting to query all customers...");
        final List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        log.trace("Query all customers result : {}", customers);
        return customers;
    }

    /**
     * TODO
     * @param name
     * @return
     */
    public Customer createCustomer(final String name) {
        log.trace("Creating customer with name : {}", name);
        return Optional.ofNullable(name)
                .map(Customer::new)
                .map(customerRepository::save)
                .orElseThrow();
    }


}
