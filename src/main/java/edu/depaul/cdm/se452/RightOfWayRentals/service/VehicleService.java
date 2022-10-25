package edu.depaul.cdm.se452.RightOfWayRentals.service;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleType;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.VehicleRepository;
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
     * TODO
     * @param vehicleId
     * @return
     */
    public Vehicle getVehicleById(Long vehicleId) {
        log.trace("Querying vehicle with ID : {}", vehicleId);
        return vehicleRepository.findById(vehicleId).orElseThrow();
    }

    /**
     * TODO
     * @return
     */
    public List<Vehicle> getAllVehicles() {
        log.trace("Attempting to query all vehicles...");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicleRepository.findAll().forEach(vehicles::add);
        log.trace("Query all vehicles result : {}", vehicles);
        return vehicles;
    }

    /**
     * TODO
     * @param type
     * @param make
     * @param model
     * @param mileage
     * @return
     */
    public Vehicle addVehicle(final VehicleType type, final VehicleMake make, final String model , final int mileage) {
        log.trace("Creating vehicle with\tVehicleType:{}\tVehicleMake:{}\tVehicleModel:{}\tVehicleMilage:{}", type, make, model, mileage);
        final Vehicle vehicle = new Vehicle(type, make, model, mileage);
        log.trace("Attempting to save Vehicle : {}", vehicle);
        return vehicleRepository.save(vehicle);
    }

}
