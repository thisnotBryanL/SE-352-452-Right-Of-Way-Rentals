package edu.depaul.cdm.se452.RightOfWayRentals.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LOCATIONS")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String zipcode;

    @Column
    private String city;

    @Column(length = 2)
    private String state;


}
