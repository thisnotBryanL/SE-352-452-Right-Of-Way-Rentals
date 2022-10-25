package edu.depaul.cdm.se452.rightOfWayRentals.data.pojo;

import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Vehicle;
import lombok.*;

@Setter
@EqualsAndHashCode
@ToString
public final class CustomerVehiclePair {
    private final Customer customer;
    private final Vehicle vehicle;

    private CustomerVehiclePair(final Customer customer, final Vehicle vehicle) {
        this.customer = customer;
        this.vehicle = vehicle;
    }

    public Customer customer() {
        return customer;
    }

    public Vehicle vehicle() {
        return vehicle;
    }

    public static CustomerVehiclePair of(final Customer customer, final Vehicle vehicle) {
        return new CustomerVehiclePair(customer, vehicle);
    }
}
