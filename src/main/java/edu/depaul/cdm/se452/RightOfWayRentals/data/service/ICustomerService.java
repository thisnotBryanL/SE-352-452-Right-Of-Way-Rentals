package edu.depaul.cdm.se452.RightOfWayRentals.data.service;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomerService {
    ResponseEntity<Customer> getCustomerByCID(String customerID);
    ResponseEntity<Customer>  getCustomerByRID(String reservationID);
    ResponseEntity<List<Customer>> getAllCustomers();

}
