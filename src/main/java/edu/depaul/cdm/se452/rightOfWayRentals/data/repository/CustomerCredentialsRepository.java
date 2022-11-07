package edu.depaul.cdm.se452.rightOfWayRentals.data.repository;


import edu.depaul.cdm.se452.rightOfWayRentals.data.model.CustomerCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerCredentialsRepository extends MongoRepository<CustomerCredentials, String> {
    @Query("{username:?0}")
    Optional<CustomerCredentials> findByUsername(String username);
}
