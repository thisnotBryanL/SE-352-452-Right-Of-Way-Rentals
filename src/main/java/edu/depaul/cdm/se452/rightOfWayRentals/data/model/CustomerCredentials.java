package edu.depaul.cdm.se452.rightOfWayRentals.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document(collection = "CustomerCredentials")
public class CustomerCredentials {
    @Id
    private String id;
    private String username;
    private String password;
    private String role;
    private Long customerId;

}
