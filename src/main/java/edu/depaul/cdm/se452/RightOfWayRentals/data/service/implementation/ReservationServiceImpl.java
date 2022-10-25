package edu.depaul.cdm.se452.RightOfWayRentals.data.service.implementation;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.IReservationRepository;
import edu.depaul.cdm.se452.RightOfWayRentals.data.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationServiceImpl implements IReservationService {
    @Autowired
    IReservationRepository reservationRepo;

    @Override
    public Reservation getReservationByRID(String reservationID) {
        return null;
    }

    @Override
    public Reservation getReservationByCID(String customerID) {
        return null;
    }

    @Override
    public Reservation getReservationByEID(String employeeID) {
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }

    @Override
    public String addReservation(String customerID, String employeeID, String VehicleID, String date) {
        return null;
    }
}
