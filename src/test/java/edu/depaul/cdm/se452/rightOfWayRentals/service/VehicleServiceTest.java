package edu.depaul.cdm.se452.rightOfWayRentals.service;

import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleType;
import edu.depaul.cdm.se452.rightOfWayRentals.data.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {
    @Mock
    VehicleRepository repository;
    VehicleService service;

    @BeforeEach
    void initService() {
        service = new VehicleService(repository);
    }

    @Test
    void getVehicleById() {
        final Vehicle expected = new Vehicle(1, VehicleType.MERCEDES, VehicleMake.SEDAN, "C300", 12, true, Collections.emptyList());
        when(repository.findById(expected.getId()))
                .thenReturn(Optional.of(expected));
        assertThat(service.getVehicleById(expected.getId()))
                .isEqualTo(expected);
    }

    @Test
    void givenVehicleIdThatIsNonExistentShouldThrow() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class, () -> service.getVehicleById(1L));
    }

    @Test
    void getAllVehicles() {
        final Vehicle v1 = new Vehicle(1, VehicleType.SUBARU, VehicleMake.SUV, "S111", 202, true, Collections.emptyList());
        final Vehicle v2 = new Vehicle(1, VehicleType.ROLLSROYCE, VehicleMake.CONVERTIBLE, "DropTopWop", 1, true, Collections.emptyList());
        final List<Vehicle> expected = Arrays.asList(
                v1, v2
        );
        when(repository.findAll()).thenReturn(expected);
        assertThat(service.getAllVehicles()).isEqualTo(expected);
    }

    @Test
    void getAllVehiclesWhenNoVehicles() {
        final List<Vehicle> vehicles = Collections.emptyList();
        when(repository.findAll()).thenReturn(vehicles);
        assertThat(repository.findAll()).isEmpty();
    }

    @Test
    void addVehicle() {
        final VehicleType type = VehicleType.AUDI;
        final VehicleMake make = VehicleMake.PICKUP;
        final String model = "Audster";
        final int mileage = 23444;
        final Vehicle expected = new Vehicle(type, make, model, mileage, false);
        when(repository.save(any(Vehicle.class))).thenReturn(expected);

        assertThat(service.addVehicle(type, make, model, mileage)).isEqualTo(expected);


    }




}