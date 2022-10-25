package edu.depaul.cdm.se452.RightOfWayRentals.data.service.implementation;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleType;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.IVehicleRepository;
import edu.depaul.cdm.se452.RightOfWayRentals.data.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleServiceImpl implements IVehicleService {
    @Autowired
    IVehicleRepository vehicleRepo;

    @Override
    public Vehicle getVehicleByVID(String vehicleID) {
        return null;
    }

    @Override
    public Vehicle getVehicleByRID(String reservationID) {
        return null;
    }

    @Override
    public List<Vehicle> getVehilclesByCID(String customerID) {
        return null;
    }

    @Override
    public List<Vehicle> getVehiclesByEID(String employeeID) {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return null;
    }

    @Override
    public Long addVehicle(VehicleType type, VehicleMake make, String model, int mileage, boolean available) {
        return null;
    }
}
