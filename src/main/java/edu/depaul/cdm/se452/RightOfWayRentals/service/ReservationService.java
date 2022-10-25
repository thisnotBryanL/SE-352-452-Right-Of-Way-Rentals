package edu.depaul.cdm.se452.RightOfWayRentals.service;

import edu.depaul.cdm.se452.RightOfWayRentals.component.ReservationHelper;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.CustomerVehiclePair;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {

    final ReservationRepository reservationRepository;
    final ReservationHelper helper;

    /**
     * TODO
     * @param id
     * @return
     */
    public Reservation getReservationById(Long id) {
        log.trace("Attempting to find reservation with ID : {}", id);
        return reservationRepository.findById(id).orElseThrow();
    }

    /**
     * TODO
     * @return
     */
    public List<Reservation> getAllReservations() {
        log.trace("Attempting to query for all reservations...");
        final List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);
        log.trace("Get all reservations results : {}", reservations);
        return reservations;
    }

    /**
     * TODO
     * @return
     */
    public List<Reservation> getReservationsWithCustomerId(final Long customerId) {
        log.trace("Attempting to find all reservations with customer ID : {}", customerId);
        return reservationRepository.findAllByCustomer(helper.getCustomerWithId(customerId));
    }

    /**
     * TODO
     * @return
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



}
