package edu.depaul.cdm.se452.rightOfWayRentals.service;

import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleType;
import edu.depaul.cdm.se452.rightOfWayRentals.data.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleService {

    final VehicleRepository vehicleRepository;

    /**
     * Search for a vehicle using vehicle ID
     * @param vehicleId Input the unique vehicle ID
     * @return Vehicle Make, Model, Type & current status
     */
    public Vehicle getVehicleById(Long vehicleId) {
        log.trace("Querying vehicle with ID : {}", vehicleId);
        return vehicleRepository.findById(vehicleId).orElseThrow();
    }

    /**
     * View all vehicles owned by the company
     * @return  The list of all vehicles owned by the company
     */
    public List<Vehicle> getAllVehicles() {
        log.trace("Attempting to query all vehicles...");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicleRepository.findAll().forEach(vehicles::add);
        log.trace("Query all vehicles result : {}", vehicles);
        return vehicles;
    }

    /**
     * Create a new vehicle and add it to the rental fleet
     * @param type Input the vehicle type
     * @param make Input the make of vehicle
     * @param model Input the model of vehicle
     * @param mileage Input the current mileage
     * @return A new vehicle and save it in the vehicle repository
     */
    public Vehicle addVehicle(final VehicleType type, final VehicleMake make, final String model , final int mileage) {
        log.trace("Creating vehicle with\tVehicleType:{}\tVehicleMake:{}\tVehicleModel:{}\tVehicleMilage:{}", type, make, model, mileage);
        final Vehicle vehicle = new Vehicle(type, make, model, mileage);
        log.trace("Attempting to save Vehicle : {}", vehicle);
        return vehicleRepository.save(vehicle);
    }

}
