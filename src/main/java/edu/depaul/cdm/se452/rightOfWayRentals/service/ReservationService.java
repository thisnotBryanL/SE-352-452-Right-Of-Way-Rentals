package edu.depaul.cdm.se452.rightOfWayRentals.service;

import edu.depaul.cdm.se452.rightOfWayRentals.component.ReservationHelper;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.CustomerVehiclePair;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.ReservationStatus;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.request.PostReservationRequest;
import edu.depaul.cdm.se452.rightOfWayRentals.data.repository.ReservationRepository;
import edu.depaul.cdm.se452.rightOfWayRentals.exception.RightOfWayRentalsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {

    final ReservationRepository reservationRepository;
    final ReservationHelper helper;

    /**
     * Search for reservation using reservation ID
     * @param id Input the unique reservation ID
     * @return Reservation info & status
     */
    public Reservation getReservationById(Long id) {
        log.trace("Attempting to find reservation with ID : {}", id);
        return reservationRepository.findById(id).orElseThrow();
    }

    /**
     * Return the list of all reservations, info & status.
     * @return The list of all reservations
     */
    public List<Reservation> getAllReservations() {
        log.trace("Attempting to query for all reservations...");
        final List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);
        log.trace("Get all reservations results : {}", reservations);
        return reservations;
    }

    /**
     * Search for a reservation info & status using a customer ID
     * @return Reservation info & status by customer ID
     */
    public List<Reservation> getReservationsWithCustomerId(final Long customerId) {
        log.trace("Attempting to find all reservations with customer ID : {}", customerId);
        return reservationRepository.findAllByCustomer(helper.getCustomerWithId(customerId));
    }

    /**
     * Search for a reservation info & status using a vehicle ID
     * @return Reservation info & status by vehicle ID
     */
    public List<Reservation> getReservationsWithVehicleId(final Long vehicleId) {
        log.trace("Attempting to find all reservations with vehicle ID : {}", vehicleId);
        return reservationRepository.findAllByVehicle(helper.getVehicleWithId(vehicleId));
    }

    public List<Reservation> getReservationsWithCustomerAndVehicle(final Long customerId, final Long vehicleId) {
        log.trace("Attempting to query customer by ID : {} and Vehicle by ID : {}", customerId, vehicleId);
        final CustomerVehiclePair cvPair = helper.getCustomerVehiclePair(customerId, vehicleId);
        log.trace("Found customer vehicle pair : {}", cvPair);
        log.trace("Attempting to find all reservations with customer / vehicle pair: {}", cvPair);
        return reservationRepository.findAllByVehicleAndCustomer(cvPair.vehicle(), cvPair.customer());
    }

    // handle setting pickup mileage here
    // handle reservation status here
    // handle dropoff here (might need to allow nullable on table)
    public Reservation addReservation(final PostReservationRequest reservationRequest) {
        final CustomerVehiclePair cvPair = helper.getCustomerVehiclePair(reservationRequest.getCustomerId(), reservationRequest.getVehicleId());
        final Reservation reservation = Reservation.builder()
                .customer(cvPair.customer())
                .vehicle(cvPair.vehicle())
                .status(ReservationStatus.RESERVED)
                .pickupMileage(cvPair.vehicle().getMileage())
                .dropoffMileage(cvPair.vehicle().getMileage()) // will need to include method for starting reservation / ending reservation
                .pickup(LocalDateTime.parse(reservationRequest.getPickup()))
                .dropoff(LocalDateTime.parse(reservationRequest.getDropOffTime()))
                .build();
        return reservationRepository.save(reservation);
    }

    /**
     *
     * @param customerID Customers ID
     * @param vehicleID ID of the vehicle the customer wants to be rented
     * @param pickupTime The LocalDateTime string the customer wants to pick up the vehicle (format: yyyy-MM-dd-HH:mm)
     * @param dropOffTime The LocalDateTime string the customer wants to return the vehicle (format: yyyy-MM-dd-HH:mm)
     * @return Reservation and also persists to database
     */
    public Reservation addReservation(Long customerID, Long vehicleID, String pickupTime, String dropOffTime){

        var cvPair = helper.getCustomerVehiclePair(customerID,vehicleID);
        var newReservation = Reservation.newReservation(cvPair.customer(),cvPair.vehicle(),pickupTime,dropOffTime);
        return reservationRepository.save(newReservation);
    }

    public Reservation removeReservation(Long reservationId) {
        log.trace("Removing reservation with ID : {}", reservationId);
        final Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RightOfWayRentalsException("Could not find reservation with ID : " + reservationId));
        log.trace("Found reservation : {}", reservation);
        reservationRepository.delete(reservation);
        log.trace("Removed reservation : {}", reservation);
        return reservation;
    }


}
