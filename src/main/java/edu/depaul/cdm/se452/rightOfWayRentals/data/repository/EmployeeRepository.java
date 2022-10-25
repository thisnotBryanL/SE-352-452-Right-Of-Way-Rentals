package edu.depaul.cdm.se452.rightOfWayRentals.data.repository;

import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> { }
