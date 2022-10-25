package edu.depaul.cdm.se452.rightOfWayRentals.controller;

import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.request.PostReservationRequest;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.request.PostVehicleRequest;
import edu.depaul.cdm.se452.rightOfWayRentals.service.CustomerService;
import edu.depaul.cdm.se452.rightOfWayRentals.service.ReservationService;
import edu.depaul.cdm.se452.rightOfWayRentals.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
@Tag(name = "RentalCarService", description = "Rental car application")
@Slf4j
public class RentalCarController {

    final VehicleService vehicleService;
    final CustomerService customerService;
    final ReservationService reservationService;


    @GetMapping(value = "customers/{customerId}")
    @Operation(summary = "Returns the customer that matches the supplied Customer ID")
    public Customer getCustomer(@PathVariable final Long customerId) {
        log.trace("getCustomer : {}", customerId);
        return customerService.getCustomerById(customerId);
    }

    @GetMapping(value = "customers")
    @Operation(summary = "Returns a list of all customers in the customer table")
    @ApiResponse(responseCode = "200", description = "valid response", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))})
    public List<Customer> allCustomers() {
        log.trace("allCustomers");
        return customerService.getAllCustomers();
    }

    @PostMapping(value = "customers", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Adds a customer to the customer table with the supplied customer name")
    public Customer addCustomer(@RequestBody final String customerName) {
        log.trace("addCustomer {}", customerName);
        return customerService.createCustomer(customerName);
    }

    @GetMapping(value = "vehicles/{vehicleId}")
    @Operation(description = "Gets a single vehicle with the supplied vehicle ID")
    public Vehicle getVehicle(@PathVariable final Long vehicleId) {
        log.trace("getVehicle {}", vehicleId);
        return vehicleService.getVehicleById(vehicleId);
    }

    @GetMapping(value = "vehicles")
    @Operation(description = "Gets a list of all the vehicles from the vehicle table")
    public List<Vehicle> allVehicles() {
        log.trace("allVehicles");
        return vehicleService.getAllVehicles();
    }

    @PostMapping(value = "vehicles", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Adds a single vehicle to the vehicle table with a POST request")
    public Vehicle addVehicle(@RequestBody final PostVehicleRequest request) {
        log.trace("addVehicle {}", request);
        return vehicleService.addVehicle(request.getVehicleType(), request.getVehicleMake(), request.getVehicleModel(), request.getVehicleMileage());
    }

    @GetMapping(value = "reservations/{reservationId}")
    public Reservation getReservation(@PathVariable final Long reservationId) {
        log.trace("getReservation {}", reservationId);
        return reservationService.getReservationById(reservationId);
    }

    @GetMapping(value = "reservations")
    public List<Reservation> allReservations() {
        log.trace("allReservations");
        return reservationService.getAllReservations();
    }

    @GetMapping(value = "reservations/customer/{customerId}")
    public List<Reservation> reservationsRelatedToCustomer(@PathVariable final Long customerId) {
        log.trace("reservationsRelatedToCustomer {}", customerId);
        return reservationService.getReservationsWithCustomerId(customerId);
    }

    @GetMapping(value = "reservations/vehicle/{vehicleId}")
    public List<Reservation> reservationsRelatedToVehicle(@PathVariable final Long vehicleId) {
        log.trace("reservationsRelatedToVehicle {}", vehicleId);
        return reservationService.getReservationsWithVehicleId(vehicleId);
    }

    @GetMapping(value = "reservations/multi")
    public List<Reservation> reservationsRelatedToCustomerAndVehicle(
            @RequestParam("customer") final Long customerId,
            @RequestParam("vehicle") final Long vehicleId) {
        log.trace("reservationsRelatedToCustomerAndVehicle {} {}", customerId, vehicleId);
        return reservationService.getReservationsWithCustomerAndVehicle(customerId, vehicleId);
    }

    @PostMapping(value = "reservations")
    public Reservation addReservation(@RequestBody final PostReservationRequest reservationRequest) {
        log.trace("addReservation {}", reservationRequest);
        return reservationService.addReservation(reservationRequest);
    }

    // pickuptime and dropoff time format: yyyy-MM-dd-HH:mm
    @GetMapping(value="reservations/cid={customerID}/vid={vehicleID}/pickup={pickupTime}/dropOffTime={dropOffTime}")
    public Reservation addReservation(@PathVariable Long customerID, @PathVariable Long vehicleID, @PathVariable String pickupTime,
                                      @PathVariable String dropOffTime){

        log.trace("Adding reservation CID = " + customerID + " VID = " + "pickup = " + pickupTime + " dropoff = " + dropOffTime );
        return reservationService.addReservation(customerID,vehicleID,pickupTime,dropOffTime);
    }

}
