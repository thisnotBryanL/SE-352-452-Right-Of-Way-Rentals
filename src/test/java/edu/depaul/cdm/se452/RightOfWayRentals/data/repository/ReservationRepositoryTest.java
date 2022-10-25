package edu.depaul.cdm.se452.RightOfWayRentals.data.repository;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.ReservationStatus;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ReservationRepositoryTest {
    final LocalDateTime now = LocalDateTime.now();
    final int mileage_start = 3333;
    final Vehicle vehicle_1 = new Vehicle(VehicleType.VOLKSWAGON, VehicleMake.PICKUP, "2022 Tiguan", mileage_start, false);
    final Customer customer_1 = new Customer(1L,"John Doe", List.of());
    Reservation reservation_1;

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @BeforeEach
    void populate() {
        customerRepository.save(customer_1);
        vehicleRepository.save(vehicle_1);
        final Customer customer = customerRepository.findById(customer_1.getId()).get();
        final Vehicle vehicle = vehicleRepository.findById(vehicle_1.getId()).get();
        reservation_1 = Reservation.builder()
                .pickup(now)
                .pickupMileage(mileage_start)
                .dropoff(LocalDateTime.MAX)
                .dropoffMileage(mileage_start + 200)
                .status(ReservationStatus.ACTIVE)
                .customer(customer)
                .vehicle(vehicle)
                .build();
        persistReservation(reservation_1);
    }

    @AfterEach
    void tearDown() {
        reservationRepository.deleteAll();
        vehicleRepository.deleteAll();
        customerRepository.deleteAll();
    }

    @Test
    void givenId_findsReservation() {
        final Reservation actual = reservationRepository.findById(1L).orElseThrow();
        assertThat(actual).isEqualTo(reservation_1);
    }

    @Test
    void getAllReservations() {
        final Vehicle vehicle_2 = new Vehicle(VehicleType.UNSPECIFIED, VehicleMake.MINIVAN, "Model", 200, true);
        vehicleRepository.save(vehicle_2);
        final Customer customer = new Customer();
        customerRepository.save(customer);
        final Reservation reservation_2 = Reservation.builder()
                .pickup(now)
                .pickupMileage(100)
                .dropoff(now)
                .dropoffMileage(200)
                .status(ReservationStatus.COMPLETE)
                .vehicle(vehicle_2)
                .customer(customer)
                .build();
        persistReservation(reservation_2);
        assertThat(reservationRepository.findAll()).hasSize(2)
                .contains(reservation_1, reservation_2);
    }

    @Test
    void findReservationsByStatus() {
        final Reservation reservation_2 = Reservation.builder()
                .pickup(now)
                .pickupMileage(100)
                .dropoff(now)
                .dropoffMileage(200)
                .status(ReservationStatus.COMPLETE)
                .vehicle(vehicleRepository.findById(vehicle_1.getId()).get())
                .customer(customerRepository.findById(customer_1.getId()).get())
                .build();
        reservationRepository.save(reservation_2);
        final List<Reservation> actual = reservationRepository.findAllByStatus(ReservationStatus.ACTIVE);
        assertThat(actual).hasSize(1).contains(reservation_1);
    }

    @Test
    void findAllByVehicle() {
        assertThat(reservationRepository.findAllByVehicle(vehicle_1)).isEqualTo(Collections.singletonList(reservation_1));
    }

    @Test
    void findAllByCustomer() {
        assertThat(reservationRepository.findAllByCustomer(customer_1)).isEqualTo(Collections.singletonList(reservation_1));
    }

    @Test

    void findAllByCustomerAndVehicle() {
        assertThat(reservationRepository.findAllByVehicleAndCustomer(vehicle_1, customer_1)).isEqualTo(Collections.singletonList(reservation_1));

    }

    private void persistReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

}