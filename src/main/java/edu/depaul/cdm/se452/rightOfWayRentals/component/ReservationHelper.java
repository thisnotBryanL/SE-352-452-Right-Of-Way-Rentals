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
     * TODO
     * @param id
     * @return
     */
    public Customer getCustomerWithId(final Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    /**
     * TODO
     * @param id
     * @return
     */
    public Vehicle getVehicleWithId(final Long id) {
        return vehicleRepository.findById(id).orElseThrow();
    }


    /**
     * TODO
     * @param customerId
     * @param vehicleId
     * @return
     */
    public CustomerVehiclePair getCustomerVehiclePair(final Long customerId, final Long vehicleId) {
        return CustomerVehiclePair.of(getCustomerWithId(customerId), getVehicleWithId(vehicleId));
    }
}
