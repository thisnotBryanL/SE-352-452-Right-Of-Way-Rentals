package edu.depaul.cdm.se452.rightOfWayRentals.data.repository;


import edu.depaul.cdm.se452.rightOfWayRentals.data.model.CustomerCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerCredentialsRepository extends MongoRepository<CustomerCredentials, String> {
    public CustomerCredentials findByUsername(String username);
}
