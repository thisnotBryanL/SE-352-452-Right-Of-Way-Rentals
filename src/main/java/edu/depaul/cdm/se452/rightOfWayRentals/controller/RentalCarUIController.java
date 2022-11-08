package edu.depaul.cdm.se452.rightOfWayRentals.controller;

import edu.depaul.cdm.se452.rightOfWayRentals.component.SecurityHelper;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.request.PostReservationRequest;
import edu.depaul.cdm.se452.rightOfWayRentals.security.CustomerUserDetails;
import edu.depaul.cdm.se452.rightOfWayRentals.service.CustomerService;
import edu.depaul.cdm.se452.rightOfWayRentals.service.ReservationService;
import edu.depaul.cdm.se452.rightOfWayRentals.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RentalCarUIController {

    private final CustomerService customerService;
    private final ReservationService reservationService;
    private final VehicleService vehicleService;
    private final SecurityHelper securityHelper;

    /**
     * Redirects users to homepage if they do not type in the full path
     */
    @GetMapping(value = "/")
    public RedirectView redirectToHome() {
        return new RedirectView("/home");
    }

    /**
     * User Homepage to accepts login credentials
     */
    @GetMapping("home")
    public String home(final Model model) {
        final CustomerUserDetails currentCustomer = securityHelper.getCurrentCustomer();
        model.addAttribute("username", currentCustomer.getUsername());
        return "home";
    }

    /**
     * Route to retrieve all user reservations
     */
    @GetMapping("/reservations")
    public String getCustomerReservations(final Model model) {
        final CustomerUserDetails currentCustomer = securityHelper.getCurrentCustomer();
        model.addAttribute(
                "reservations",
                reservationService.getReservationsWithCustomerId(currentCustomer.getCustomerId())
        );
        return "customer-reservations";
    }

    /**
     * Get all User Vehicles
     */
    @GetMapping("/vehicles/all")
    public String getVehicles(final Model model) {
        log.trace("Retrieving all vehicles to display on UI");
        final List<Vehicle> allVehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", allVehicles);
        log.trace("Returning vehicles view with {} vehicles listed", allVehicles.size());
        return "vehicles";
    }

    /**
     * Reserve a specific vehicle matching the vehicle ID
     */
    @GetMapping("/vehicles/reserve/{id}")
    public String reserveVehicleWithId(@PathVariable final Long id, final Model model) {
        log.trace("Retrieving data required for reserve vehicle view with vehicle ID {}", id);
        final PostReservationRequest formWrapper = new PostReservationRequest();
        formWrapper.setVehicleId(id);
        model.addAttribute("reservationRequest", formWrapper);
        model.addAttribute("vehicleId", id);
        log.trace("Returning reserve vehicle view with reservation request DAO attached to model.");
        return "reserve-vehicle";
    }

    /**
     * Reserve any available vehicle
     */
    @PostMapping("/vehicles/reserve")
    public String postReservationForVehicle(@ModelAttribute PostReservationRequest reservationRequest, final Model model) {
        log.trace("Received request to reserve vehicle with ID : {}",reservationRequest.getVehicleId());
        reservationRequest.setCustomerId(securityHelper.getCurrentCustomer().getCustomerId());
        final Reservation reservation = reservationService.addReservation(reservationRequest);
        model.addAttribute("message", "Successfully created reservation : " + reservation.toString());
        log.trace("Reservation for vehicle ID {} successful", reservationRequest.getVehicleId());
        return "success";
    }

    /**
     * Cancel spcific reservation that matches specified reservation ID
     */
    @GetMapping("/reservations/{id}/cancel")
    public String cancelReservation(@PathVariable final Long id, final Model model) {
        log.trace("Beginning to cancel reservation with ID : {}", id);
        final Reservation reservation = reservationService.removeReservation(id);
        model.addAttribute("message", "Reservation with ID : " + id + " was successfully removed. Referenced reservation : " + reservation);
        return "success";
    }

}
