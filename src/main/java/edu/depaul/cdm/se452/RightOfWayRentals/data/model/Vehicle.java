package edu.depaul.cdm.se452.RightOfWayRentals.data.model;

import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VEHICLES")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private VehicleType type;

    @Column(columnDefinition = "varchar(30) default 'UNSPECIFIED'")
    private VehicleMake make;

    @Column
    private String model;

    @Column
    private int mileage;

    @Column
    private boolean available;

    public Vehicle(VehicleType type, VehicleMake make, String model, int mileage, boolean available) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.available = available;
    }

}
