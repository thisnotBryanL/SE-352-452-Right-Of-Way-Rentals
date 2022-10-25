package edu.depaul.cdm.se452.RightOfWayRentals.data.service.implementation;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Employee;
import edu.depaul.cdm.se452.RightOfWayRentals.data.repository.IEmployeeRepository;
import edu.depaul.cdm.se452.RightOfWayRentals.data.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepo;

    @Override
    public Employee getEmployeeByEID(String employeeID) {
        return null;
    }

    @Override
    public Employee getEmployeeByRID(String reservationID) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }
}
