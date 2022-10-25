package edu.depaul.cdm.se452.RightOfWayRentals.data.service;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getCustomerByCID(String customerID);
    Customer getCustomerByRID(String reservationID);
    List<Customer> getAllCustomers();

}
