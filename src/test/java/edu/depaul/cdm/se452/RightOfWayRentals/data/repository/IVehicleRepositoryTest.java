package edu.depaul.cdm.se452.RightOfWayRentals.data.repository;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleType;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.implementation.VehicleRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class IVehicleRepositoryTest {

    @Autowired
    private VehicleRepositoryImpl repository;

    final Vehicle vehicle_1 = new Vehicle(VehicleType.MERCEDES, VehicleMake.COUPE, "2022 Car", 555, true);

    @BeforeEach
    void populate() {
        persisteVehicle(vehicle_1);
    }

    @AfterEach
    void clear() { repository.deleteAll(); }

    @Test
    void givenIdFindsVehicle() {
        final Vehicle vehicle = repository.findById(1L).orElseThrow();
        assertThat(vehicle).isEqualTo(vehicle_1);
    }

    @Test
    void getAllVehicles() {
        final Vehicle vehicle_2 = new Vehicle(VehicleType.SUBARU, VehicleMake.SUV, "2022 Subaru", 1, false);
        persisteVehicle(vehicle_2);
        final Iterable<Vehicle> all = repository.findAll();
        assertThat(all).hasSize(2).contains(vehicle_1, vehicle_2);
    }

    @Test
    void updateVehicle() {
        final Vehicle vehicle = repository.findById(1L).orElseThrow();
        vehicle.setAvailable(false);
        repository.save(vehicle);
        assertThat(repository.findById(1L).orElseThrow().isAvailable()).isFalse();
    }

    private void persisteVehicle(Vehicle vehicle) {
        repository.save(vehicle);
    }



}