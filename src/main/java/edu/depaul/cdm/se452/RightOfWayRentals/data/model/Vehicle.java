package edu.depaul.cdm.se452.RightOfWayRentals.data.model;

import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleMake;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    //Builder Pattern may be useful for later
//    public static Vehicle createVehicle(VehicleType type, VehicleMake make, String model, int mileage, boolean available) {
//        return Vehicle.builder()
//                .type(type)
//                .make(make)
//                .model(model)
//                .available(available)
//                .build();
//    }

}
