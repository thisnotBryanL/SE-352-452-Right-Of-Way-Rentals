package edu.depaul.cdm.se452.RightOfWayRentals.data.repository;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> { }
