package edu.depaul.cdm.se452.RightOfWayRentals.data.service.implementation;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.ICustomerRepository;
import edu.depaul.cdm.se452.RightOfWayRentals.data.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepo;

    @GetMapping("/customer/customerID/{customerID}")
    @Override
    public ResponseEntity<Customer> getCustomerByCID(@PathVariable  String customerID) {
        var customer = customerRepo.findById(Long.valueOf(customerID));
        if(customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer/reservationID/{reservationID}")
    @Override
    public ResponseEntity<Customer>  getCustomerByRID(@PathVariable  String reservationID) {
        return null;
    }

    @GetMapping("/customer/all-customers")
    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {
//        var customersList = customerRepo.findAll();
//        List<Customer> customers = new ArrayList<>();
//        while(customersList.iterator().hasNext()){
//            customers.add(customersList.iterator().next());
//        }
//        if(customers.size()>0) {
//            return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
//        }else{
//            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
//        }
        return null;
    }
}
