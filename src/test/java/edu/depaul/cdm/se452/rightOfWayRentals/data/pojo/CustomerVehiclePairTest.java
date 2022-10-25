package edu.depaul.cdm.se452.rightOfWayRentals.data.pojo;

import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Vehicle;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerVehiclePairTest {

    @Test
    void testPair() {
        final Customer customer = new Customer("C1");
        final Vehicle vehicle = new Vehicle(VehicleType.SUBARU, VehicleMake.SEDAN, "SUBASEDAN", 100);
        final CustomerVehiclePair customerVehiclePair = CustomerVehiclePair.of(customer, vehicle);
        assertThat(customerVehiclePair.customer()).isEqualTo(customer);
        assertThat(customerVehiclePair.vehicle()).isEqualTo(vehicle);

    }

}