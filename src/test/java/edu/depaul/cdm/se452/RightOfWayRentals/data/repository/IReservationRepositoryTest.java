package edu.depaul.cdm.se452.RightOfWayRentals.data.repository;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Employee;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.ReservationStatus;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.Role;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class IReservationRepositoryTest {
    final LocalDateTime now = LocalDateTime.now();
    final int mileage_start = 3333;
    final Vehicle vehicle_1 = new Vehicle(VehicleType.VOLKSWAGON, VehicleMake.PICKUP, "2022 Tiguan", mileage_start, false);
    final Customer customer_1 = new Customer(1L,"John Doe");
    final Employee employee_1 = new Employee(1L,"Jane Doe", Role.SALESMAN);
    final Reservation reservation_1;
    {
        reservation_1 = Reservation.builder()
                .pickup(now)
                .pickupMileage(mileage_start)
                .dropoff(LocalDateTime.MAX)
                .dropoffMileage(mileage_start + 200)
                .status(ReservationStatus.ACTIVE)
                .customerId(customer_1.getId())
                .employeeId(employee_1.getId())
                .vehicleId(vehicle_1.getId())
                .build();
    }

    @Autowired
    private IReservationRepository IReservationRepository;
    @Autowired
    private ICustomerRepository ICustomerRepository;
    @Autowired
    private IEmployeeRepository IEmployeeRepository;
    @Autowired
    private IVehicleRepository IVehicleRepository;

    @BeforeEach
    void populate() {
        persistReservation(reservation_1);
        ICustomerRepository.save(customer_1);
        IEmployeeRepository.save(employee_1);
        IVehicleRepository.save(vehicle_1);
    }

    @Test
    void givenId_findsReservation() {
        final Reservation actual = IReservationRepository.findById(1L).orElseThrow();
        assertThat(actual).isEqualTo(reservation_1);
    }

    @Test
    void getAllReservations() {
        final Vehicle vehicle_2 = new Vehicle(VehicleType.UNSPECIFIED, VehicleMake.MINIVAN, "Model", 200, true);
        IVehicleRepository.save(vehicle_2);
        final Employee employee = new Employee();
        IEmployeeRepository.save(employee);
        final Customer customer = new Customer();
        ICustomerRepository.save(customer);
        final Reservation reservation_2 = Reservation.builder()
                .pickup(now)
                .pickupMileage(100)
                .dropoff(now)
                .dropoffMileage(200)
                .status(ReservationStatus.COMPLETE)
                .vehicleId(vehicle_2.getId())
                .employeeId(employee.getId())
                .customerId(customer.getId())
                .build();
        persistReservation(reservation_2);
        assertThat(IReservationRepository.findAll()).hasSize(2)
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
                .vehicleId(1L)
                .employeeId(1L)
                .customerId(1L)
                .build();
        IReservationRepository.save(reservation_2);
        final List<Reservation> actual = IReservationRepository.findAllByStatus(ReservationStatus.ACTIVE);
        assertThat(actual).hasSize(1).contains(reservation_1);
    }

    private void persistReservation(Reservation reservation) {
        IReservationRepository.save(reservation);
    }

}