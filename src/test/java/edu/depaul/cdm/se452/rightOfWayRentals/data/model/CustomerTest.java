package edu.depaul.cdm.se452.rightOfWayRentals.data.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {

    @Test
    void testId() {
        final Customer customer = new Customer();
        assertThat(customer.getId()).isNull();
        customer.setId(1L);
        assertThat(customer.getId()).isEqualTo(1L);
    }

    @Test
    void testName() {
        final Customer customer = new Customer();
        assertThat(customer.getName()).isNull();
        final String name = "first last";
        customer.setName(name);
        assertThat(customer.getName()).isEqualTo(name);
    }

    @Test
    void testEquals() {
        final Customer customer1 = new Customer();
        final Customer customer2 = new Customer();
        final String name = "John Doe";
        assertThat(customer1).isEqualTo(customer2);
        customer1.setId(1L);
        customer1.setName(name);
        assertThat(customer1.equals(customer2)).isFalse();
        customer2.setId(1L);
        assertThat(customer1.equals(customer2)).isFalse();
        customer2.setName(name);
        assertThat(customer1.equals(customer2)).isTrue();
    }



}