package edu.depaul.cdm.se452.RightOfWayRentals.service;

import edu.depaul.cdm.se452.RightOfWayRentals.component.ReservationHelper;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    final ReservationRepository reservationRepository;
    final ReservationHelper helper;

    public Reservation getReservationById(Long id) {
        return null;
    }

    public List<Reservation> getAllReservations() {
        return Collections.emptyList();
    }

    public List<Reservation> getReservationsWithCustomerId() {
        return Collections.emptyList();
    }

    public List<Reservation> getReservationsWithVehicleId() {
        return Collections.emptyList();
    }



}
