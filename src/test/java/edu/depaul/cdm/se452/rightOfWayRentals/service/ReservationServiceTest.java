package edu.depaul.cdm.se452.rightOfWayRentals.service;

import edu.depaul.cdm.se452.rightOfWayRentals.component.ReservationHelper;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.CustomerVehiclePair;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.ReservationStatus;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleType;
import edu.depaul.cdm.se452.rightOfWayRentals.data.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock ReservationRepository reservationRepository;
    @Mock ReservationHelper reservationHelper;

    ReservationService service;

    @BeforeEach
    void initService() {
        service = new ReservationService(reservationRepository, reservationHelper);
    }
    final Vehicle vehicle = new Vehicle(VehicleType.AUDI, VehicleMake.SUV, "AUDISUB", 12423, false);
    final Customer customer = new Customer("Ted");

    @Test
    void getReservationById() {

        final Reservation expected = new Reservation(1, LocalDateTime.now(), LocalDateTime.now(), 10, 20, ReservationStatus.RESERVED, vehicle, customer);
        when(reservationRepository.findById(expected.getId())).thenReturn(Optional.of(expected));
        assertThat(service.getReservationById(expected.getId())).isEqualTo(expected);
    }

    @Test
    void getReservationWithCustomerId() {
        final Reservation expected = new Reservation(1, LocalDateTime.now(), LocalDateTime.now(), 1, 200, ReservationStatus.COMPLETE, null, customer);
        final List<Reservation> expectedList = Collections.singletonList(expected);
        when(reservationHelper.getCustomerWithId(customer.getId())).thenReturn(customer);
        when(reservationRepository.findAllByCustomer(customer)).thenReturn(expectedList);
        assertThat(service.getReservationsWithCustomerId(customer.getId())).isEqualTo(expectedList);
    }

    @Test
    void getReservationWithVehicleId() {
        final Reservation reservation = new Reservation(1, LocalDateTime.now(), LocalDateTime.now(), 2, 200, ReservationStatus.ACTIVE, vehicle, null);
        final List<Reservation> expected = Collections.singletonList(reservation);
        when(reservationHelper.getVehicleWithId(vehicle.getId())).thenReturn(vehicle);
        when(reservationRepository.findAllByVehicle(vehicle)).thenReturn(expected);
        assertThat(service.getReservationsWithVehicleId(vehicle.getId())).isEqualTo(expected);
    }

    @Test
    void getReservationWithCustomerAndVehicle() {
        final Reservation reservation = new Reservation(1, LocalDateTime.now(), LocalDateTime.now(), 2, 200, ReservationStatus.ACTIVE, vehicle, customer);
        final List<Reservation> expected = Collections.singletonList(reservation);
        when(reservationHelper.getCustomerVehiclePair(customer.getId(), vehicle.getId()))
                .thenReturn(CustomerVehiclePair.of(customer, vehicle));
        when(reservationRepository.findAllByVehicleAndCustomer(vehicle, customer)).thenReturn(expected);
        assertThat(service.getReservationsWithCustomerAndVehicle(customer.getId(), vehicle.getId()))
                .isEqualTo(expected);
    }

    @Test
    void getAllReservations() {
        final Reservation reservation = new Reservation(1, LocalDateTime.now(), LocalDateTime.now(), 2, 200, ReservationStatus.ACTIVE, vehicle, null);
        final List<Reservation> expected = Collections.singletonList(reservation);
        when(reservationRepository.findAll()).thenReturn(expected);
        assertThat(service.getAllReservations()).isEqualTo(expected);
    }



}