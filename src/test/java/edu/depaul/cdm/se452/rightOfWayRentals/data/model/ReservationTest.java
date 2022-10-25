package edu.depaul.cdm.se452.rightOfWayRentals.data.model;

import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.ReservationStatus;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

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
        assertThat(reservation.getCustomer()).isNull();
        assertThat(reservation.getStatus()).isNull();
    }

    @Test
    void testReservation() {
        final int pickupMileage = 100;
        final int dropoffMileage = 1000;
        final ReservationStatus active = ReservationStatus.ACTIVE;
        final Vehicle vehicleRented = new Vehicle(1, VehicleType.TOYOTA, VehicleMake.SEDAN, "2022 4Runner", pickupMileage, false, List.of());
        final Customer customer = new Customer(1, "John Doe", Collections.emptyList());
        final LocalDateTime dropoff = LocalDateTime.MAX;


        final Reservation reservation = Reservation.builder()
                .id(1)
                .pickup(now)
                .dropoff(dropoff)
                .pickupMileage(pickupMileage)
                .dropoffMileage(dropoffMileage)
                .status(active)
                .vehicle(vehicleRented)
                .customer(customer)
                .build();

        assertThat(reservation.getId()).isEqualTo(1);
        assertThat(reservation.getPickup()).isEqualTo(now);
        assertThat(reservation.getDropoff()).isEqualTo(dropoff);
        assertThat(reservation.getPickupMileage())
                .isEqualTo(pickupMileage)
                .isEqualTo(vehicleRented.getMileage());
        assertThat(reservation.getDropoffMileage()).isEqualTo(dropoffMileage);
        assertThat(reservation.getCustomer()).isEqualTo(customer);
        assertThat(reservation.getVehicle()).isEqualTo(vehicleRented);
        assertThat(reservation.getStatus()).isEqualTo(active);
        assertThat(reservation).isEqualTo(
                new Reservation(
                        1, now, dropoff,
                        pickupMileage, dropoffMileage, active,
                        vehicleRented, customer
                )
        );

    }


}