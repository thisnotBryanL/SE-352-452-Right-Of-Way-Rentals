package edu.depaul.cdm.se452.rightOfWayRentals.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VEHICLES")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(columnDefinition = "integer")
    @Enumerated
    private VehicleType type;

    @Column(columnDefinition = "varchar(30) default 'UNSPECIFIED'")
    @Enumerated(EnumType.STRING)
    private VehicleMake make;

    @Column
    private String model;

    @Column
    private int mileage;

    @Column
    private boolean available;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicle")
    private List<Reservation> reservations = new ArrayList<>();

    public Vehicle(VehicleType type, VehicleMake make, String model, int mileage, boolean available) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.available = available;
    }

    public Vehicle(VehicleType type, VehicleMake make, String model , int mileage) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.available = true;
        this.reservations = new ArrayList<>();
    }

}
