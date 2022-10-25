package edu.depaul.cdm.se452.RightOfWayRentals.data.repository;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.ICustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;


import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ICustomerRepositoryTest {

    @Autowired
    private ICustomerRepository repository;

    final Customer customer_1 = new Customer("Customer_1");

    @BeforeEach
    void populate() {
        persistCustomer(customer_1);
    }

    @AfterEach
    void clear() {
        repository.deleteAll();
    }


    @Test
    void givenId_willFindCorrectCustomer() {
        final Customer actualCustomer = repository.findById(1L).orElse(null);
        System.out.println(actualCustomer);
        assertThat(actualCustomer).isNotNull().isEqualTo(customer_1);
    }

    @Test
    void getAllCustomers() {
        final Customer john_doe = new Customer("John Doe");
        persistCustomer(john_doe);
        final Iterable<Customer> all = repository.findAll();
        assertThat(all).hasSize(2).contains(customer_1, john_doe);
    }

    @Test
    void existsById() {
        assertThat(repository.existsById(1L)).isTrue();
    }

    @Test
    void updateCustomer() {
        final Customer customer = new Customer("John Doe");
        persistCustomer(customer);
        final long customerID = 2L;
        final Customer customerRetrieved = repository.findById(customerID).orElseThrow();
        assertThat(customerRetrieved.getName()).isEqualTo(customer.getName());

        // update
        final String updatedName = "Jane Doe";
        customer.setName(updatedName);
        persistCustomer(customer);              // acts as an update when ref is the same

        final Customer customerUpdated = repository
                .findById(customerID)
                .orElseThrow();
        assertThat(customerUpdated.getName()).isEqualTo(updatedName);
    }

    @Test
    void whenCustomerDeleted_idContinuesToIncrement() {
        final Customer customer = new Customer("John Doe");
        persistCustomer(customer);
        assertThat(repository.findAll()).hasSize(2);
        repository.delete(customer);
        assertThat(repository.findAll()).hasSize(1);

        // new customer
        final Customer jane_doe = new Customer("Jane Doe");
        persistCustomer(jane_doe);
        assertThat(
                repository.findAllById(Collections.singletonList(2L))
        ).isEmpty();
        assertThat(
                repository.findById(3L).orElseThrow().getName()
        ).isEqualTo(jane_doe.getName());
    }

    private void persistCustomer(Customer customer) {
        repository.save(customer);
    }



}