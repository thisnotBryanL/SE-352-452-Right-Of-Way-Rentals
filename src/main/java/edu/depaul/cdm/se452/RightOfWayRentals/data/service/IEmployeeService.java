package edu.depaul.cdm.se452.RightOfWayRentals.data.service;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee getEmployeeByEID(String employeeID);
    Employee getEmployeeByRID(String reservationID);
    List<Employee> getAllEmployees();
}
