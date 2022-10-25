package edu.depaul.cdm.se452.rightOfWayRentals.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;


    public Customer(final String name) {
        this.name = name;
    }
}
