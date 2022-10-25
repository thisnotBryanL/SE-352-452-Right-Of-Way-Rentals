package edu.depaul.cdm.se452.RightOfWayRentals.controller;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Reservation;
import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.request.PostReservationRequest;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.request.PostVehicleRequest;
import edu.depaul.cdm.se452.RightOfWayRentals.service.CustomerService;
import edu.depaul.cdm.se452.RightOfWayRentals.service.ReservationService;
import edu.depaul.cdm.se452.RightOfWayRentals.service.VehicleService;
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
    @Operation(summary = "TODO")
    public Customer getCustomer(@PathVariable final Long customerId) {
        log.trace("TODO {}", customerId);
        return customerService.getCustomerById(customerId);
    }

    @GetMapping(value = "customers")
    @Operation(summary = "TODO")
    @ApiResponse(responseCode = "200", description = "valid response", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))})
    public List<Customer> allCustomers() {
        log.trace("TODO");
        return customerService.getAllCustomers();
    }

    @PostMapping(value = "customers", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "TODO")
    public Customer addCustomer(@RequestBody final String customerName) {
        log.trace("TODO {}", customerName);
        return customerService.createCustomer(customerName);
    }

    @GetMapping(value = "vehicles/{vehicleId}")
    @Operation(description = "TODO")
    public Vehicle getVehicle(@PathVariable final Long vehicleId) {
        log.trace("TODO {}", vehicleId);
        return vehicleService.getVehicleById(vehicleId);
    }

    @GetMapping(value = "vehicles")
    @Operation(description = "TODO")
    public List<Vehicle> allVehicles() {
        log.trace("TODO");
        return vehicleService.getAllVehicles();
    }

    @PostMapping(value = "vehicles", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "TODO")
    public Vehicle addVehicle(@RequestBody final PostVehicleRequest request) {
        log.trace("TODO {}", request);
        return vehicleService.addVehicle(request.getVehicleType(), request.getVehicleMake(), request.getVehicleModel(), request.getVehicleMileage());
    }

    @GetMapping(value = "reservations/{reservationId}")
    public Reservation getReservation(@PathVariable final Long reservationId) {
        log.trace("TODO {}", reservationId);
        return reservationService.getReservationById(reservationId);
    }

    @GetMapping(value = "reservations")
    public List<Reservation> allReservations() {
        log.trace("TODO");
        return reservationService.getAllReservations();
    }

    @GetMapping(value = "reservations/customer/{customerId}")
    public List<Reservation> reservationsRelatedToCustomer(@PathVariable final Long customerId) {
        log.trace("TODO {}", customerId);
        return reservationService.getReservationsWithCustomerId(customerId);
    }

    @GetMapping(value = "reservations/vehicle/{vehicleId}")
    public List<Reservation> reservationsRelatedToVehicle(@PathVariable final Long vehicleId) {
        log.trace("TODO {}", vehicleId);
        return reservationService.getReservationsWithVehicleId(vehicleId);
    }

    @GetMapping(value = "reservations/multi")
    public List<Reservation> reservationsRelatedToCustomerAndVehicle(
            @RequestParam("customer") final Long customerId,
            @RequestParam("vehicle") final Long vehicleId) {
        log.trace("TODOD {} {}", customerId, vehicleId);
        return reservationService.getReservationsWithCustomerAndVehicle(customerId, vehicleId);
    }

    @PostMapping(value = "reservations")
    public Reservation addReservation(@RequestBody final PostReservationRequest reservationRequest) {
        log.trace("TODO {}", reservationRequest);
        return reservationService.addReservation(reservationRequest);
    }

}
