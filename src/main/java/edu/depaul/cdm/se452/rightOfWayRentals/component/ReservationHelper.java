package edu.depaul.cdm.se452.rightOfWayRentals.component;

import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Vehicle;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.CustomerVehiclePair;
import edu.depaul.cdm.se452.rightOfWayRentals.data.repository.CustomerRepository;
import edu.depaul.cdm.se452.rightOfWayRentals.data.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReservationHelper {

    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;

    /**
     * This helper method grabs the customer row that has the matching ID
     * @param id Customer ID
     * @return Customer that matches ID
     */
    public Customer getCustomerWithId(final Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    /**
     * This helper method grabs the vehicle row that has the matching ID
     * @param id Vehicle ID
     * @return Vehicle that matches ID
     */
    public Vehicle getVehicleWithId(final Long id) {
        return vehicleRepository.findById(id).orElseThrow();
    }


    /**
     * This method creates a CustomerVehiclePair which matches the customer and vehicle together based off
     *  of there IDs
     * @param customerId Customer ID
     * @param vehicleId Vehicle ID
     * @return Customer Vehicle Pair
     */
    public CustomerVehiclePair getCustomerVehiclePair(final Long customerId, final Long vehicleId) {
        return CustomerVehiclePair.of(getCustomerWithId(customerId), getVehicleWithId(vehicleId));
    }
}
