package edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.request;

import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleType;
import lombok.Data;

@Data
public class PostVehicleRequest {
    private VehicleType vehicleType;
    private VehicleMake vehicleMake;
    private String vehicleModel;
    private Integer vehicleMileage;
}
