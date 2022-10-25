package edu.depaul.cdm.se452.rightOfWayRentals.data.repository;

import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.ReservationStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findAllByStatus(ReservationStatus reservationStatus);
    List<Reservation> findAllByVehicleAndCustomer(Vehicle vehicle, Customer customer);
    List<Reservation> findAllByVehicle(Vehicle vehicle);
    List<Reservation> findAllByCustomer(Customer customer);
}
