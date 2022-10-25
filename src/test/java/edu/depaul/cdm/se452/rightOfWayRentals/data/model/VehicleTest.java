package edu.depaul.cdm.se452.rightOfWayRentals.data.model;

import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleTest {

    @Test
    void testEmpty() {
        final Vehicle vehicle = new Vehicle();
        assertThat(vehicle.getId()).isZero();
        assertThat(vehicle.getMake()).isNull();
        assertThat(vehicle.getMileage()).isZero();
        assertThat(vehicle.getModel()).isNull();
        assertThat(vehicle.getType()).isNull();
        assertThat(vehicle).isEqualTo(new Vehicle());
    }

    @Test
    void testVehicle() {
        final int id = 1;
        final VehicleType vehicleType = VehicleType.ROLLSROYCE;
        final VehicleMake make = VehicleMake.SEDAN;
        final String model = "2022 Ghost";
        final int mileage = 100;
        final Vehicle vehicle = new Vehicle(id, vehicleType, make, model, mileage, true);
        assertThat(vehicle.isAvailable()).isTrue();
        assertThat(vehicle.getId()).isEqualTo(id);
        assertThat(vehicle.getMake()).isEqualTo(make);
        assertThat(vehicle.getModel()).isEqualTo(model);
        assertThat(vehicle.getMileage()).isEqualTo(mileage);
        assertThat(vehicle.getType()).isEqualTo(vehicleType);
        assertThat(vehicle)
                .isNotEqualTo(new Vehicle(id, vehicleType, make, model, mileage, false))
                .isEqualTo(new Vehicle(id, vehicleType, make, model, mileage, true));
    }


}