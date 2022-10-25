package edu.depaul.cdm.se452.RightOfWayRentals.component;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.CustomerVehiclePair;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleType;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.CustomerRepository;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservationHelperTest {
    @Mock CustomerRepository customerRepository;
    @Mock VehicleRepository vehicleRepository;

    ReservationHelper helper;

    @BeforeEach
    void init() {
        helper = new ReservationHelper(vehicleRepository, customerRepository);
    }

    @Test
    void getCustomerWithId() {
        Long customerId = 1L;
        final Customer expected = new Customer(customerId, "Alice", Collections.emptyList());
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(expected));
        assertThat(helper.getCustomerWithId(customerId)).isEqualTo(expected);
    }

    @Test
    void getVehicleWithId() {
        final long vehicleId = 1L;
        final Vehicle expected = new Vehicle(vehicleId, VehicleType.AUDI, VehicleMake.SUV, "AUDISUV", 102323, false, Collections.emptyList());
        when(vehicleRepository.findById(vehicleId)).thenReturn(Optional.of(expected));
        assertThat(helper.getVehicleWithId(vehicleId)).isEqualTo(expected);
    }

    @Test
    void getCustomerVehiclePair() {
        Long customerId = 1L;
        final Customer expected_customer = new Customer(customerId, "Alice", Collections.emptyList());
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(expected_customer));
        final long vehicleId = 1L;
        final Vehicle expected_vehicle = new Vehicle(vehicleId, VehicleType.AUDI, VehicleMake.SUV, "AUDISUV", 102323, false, Collections.emptyList());
        when(vehicleRepository.findById(vehicleId)).thenReturn(Optional.of(expected_vehicle));

        assertThat(helper.getCustomerVehiclePair(expected_customer.getId(), expected_vehicle.getId()))
                .isEqualTo(CustomerVehiclePair.of(expected_customer, expected_vehicle));


    }



}