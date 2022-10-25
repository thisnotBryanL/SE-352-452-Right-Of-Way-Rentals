package edu.depaul.cdm.se452.rightOfWayRentals.data.model;

import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.ReservationStatus;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.Role;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationTest {
    static final LocalDateTime now = LocalDateTime.now();

    @Test
    void testEmpty() {
        final Reservation reservation = new Reservation();
        assertThat(reservation.getId()).isZero();
        assertThat(reservation.getPickup()).isNull();
        assertThat(reservation.getDropoff()).isNull();
        assertThat(reservation.getPickupMileage()).isZero();
        assertThat(reservation.getDropoffMileage()).isZero();
        assertThat(reservation.getCustomerId()).isNull();
        assertThat(reservation.getEmployeeId()).isNull();
        assertThat(reservation.getVehicleId()).isNull();
        assertThat(reservation.getStatus()).isNull();
    }

    @Test
    void testReservation() {
        final int pickupMileage = 100;
        final int dropoffMileage = 1000;
        final ReservationStatus active = ReservationStatus.ACTIVE;
        final Vehicle vehicleRented = new Vehicle(1, VehicleType.TOYOTA, VehicleMake.SEDAN, "2022 4Runner", pickupMileage, false);
        final Customer customer = new Customer(1, "John Doe");
        final Employee employee = new Employee(1, "Jane Doe", Role.SALESMAN);
        final LocalDateTime dropoff = LocalDateTime.MAX;


        final Reservation reservation = Reservation.builder()
                .id(1)
                .pickup(now)
                .dropoff(dropoff)
                .pickupMileage(pickupMileage)
                .dropoffMileage(dropoffMileage)
                .status(active)
                .vehicleId(vehicleRented.getId())
                .customerId(customer.getId())
                .employeeId(employee.getId())
                .build();

        assertThat(reservation.getId()).isEqualTo(1);
        assertThat(reservation.getPickup()).isEqualTo(now);
        assertThat(reservation.getDropoff()).isEqualTo(dropoff);
        assertThat(reservation.getPickupMileage())
                .isEqualTo(pickupMileage)
                .isEqualTo(vehicleRented.getMileage());
        assertThat(reservation.getDropoffMileage()).isEqualTo(dropoffMileage);
        assertThat(reservation.getCustomerId()).isEqualTo(customer.getId());
        assertThat(reservation.getEmployeeId()).isEqualTo(employee.getId());
        assertThat(reservation.getVehicleId()).isEqualTo(vehicleRented.getId());
        assertThat(reservation.getStatus()).isEqualTo(active);
        assertThat(reservation).isEqualTo(
                new Reservation(
                        1, now, dropoff,
                        pickupMileage, dropoffMileage, active,
                        vehicleRented.getId(), customer.getId(), employee.getId()
                )
        );

    }


}