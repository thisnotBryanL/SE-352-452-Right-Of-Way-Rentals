package edu.depaul.cdm.se452.RightOfWayRentals.data.service.implementation;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.ICustomerRepository;
import edu.depaul.cdm.se452.RightOfWayRentals.data.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepo;

    @Override
    public Customer getCustomerByCID(String customerID) {
        return null;
    }

    @Override
    public Customer getCustomerByRID(String reservationID) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }
}
