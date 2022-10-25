package edu.depaul.cdm.se452.RightOfWayRentals.data.service;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation getReservationByRID(String reservationID);
    Reservation getReservationByCID(String customerID);
    Reservation getReservationByEID(String employeeID);
    List<Reservation> getAllReservations();

    String addReservation(String customerID, String employeeID, String VehicleID, String date);
}
