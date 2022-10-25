package edu.depaul.cdm.se452.RightOfWayRentals.data.service;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleType;

import java.util.List;

public interface IVehicleService {
    Vehicle getVehicleByVID(String vehicleID);
    Vehicle getVehicleByRID(String reservationID);
    List<Vehicle> getVehilclesByCID(String customerID);
    List<Vehicle> getVehiclesByEID(String employeeID);
    List<Vehicle> getAllVehicles();

    Long addVehicle(VehicleType type, VehicleMake make, String model, int mileage, boolean available);
}
