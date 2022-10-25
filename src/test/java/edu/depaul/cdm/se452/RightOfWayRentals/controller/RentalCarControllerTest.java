package edu.depaul.cdm.se452.RightOfWayRentals.controller;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.ReservationStatus;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleType;
import edu.depaul.cdm.se452.RightOfWayRentals.service.CustomerService;
import edu.depaul.cdm.se452.RightOfWayRentals.service.ReservationService;
import edu.depaul.cdm.se452.RightOfWayRentals.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentalCarControllerTest {

    @Mock VehicleService vehicleService;
    @Mock CustomerService customerService;
    @Mock ReservationService reservationService;

    RentalCarController controller;

    @BeforeEach
    void initController() {
        controller= new RentalCarController(vehicleService, customerService, reservationService);
    }

    final Vehicle vehicle = new Vehicle(VehicleType.AUDI, VehicleMake.SUV, "AUDISUB", 12423, false);
    final Customer customer = new Customer("Ted");
    final Reservation reservation = new Reservation(1, LocalDateTime.now(), LocalDateTime.now(), 2, 200, ReservationStatus.ACTIVE, vehicle, customer);


    @Test
    void getCustomer() {
        when(customerService.getCustomerById(anyLong())).thenReturn(customer);
        assertThat(controller.getCustomer(1L))
                .isEqualTo(customer);
    }

    @Test
    void allCustomers() {
        final List<Customer> expected = Collections.singletonList(customer);
        when(customerService.getAllCustomers()).thenReturn(expected);
        assertThat(controller.allCustomers()).isEqualTo(expected);
    }

    @Test
    void addCustomer() {


    }

    @Test
    void getVehicle() {

    }

    @Test
    void allVehicles() {
    }

    @Test
    void addVehicle() {
    }

    @Test
    void getReservation() {
    }

    @Test
    void allReservations() {
    }

    @Test
    void reservationsRelatedToCustomer() {
    }

    @Test
    void reservationsRelatedToVehicle() {}

    @Test
    void reservationsRelatedToBoth() {}

    @Test
    void addReservation() {}

}