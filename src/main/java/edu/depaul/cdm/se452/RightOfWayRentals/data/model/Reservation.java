package edu.depaul.cdm.se452.RightOfWayRentals.data.model;

import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.ReservationStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "RESERVATIONS")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(name = "pickup_time")
    private LocalDateTime pickup;

    @Column(name = "dropoff_time")
    private LocalDateTime dropoff;

    @Column(name = "pickup_mileage")
    private int pickupMileage;

    @Column(name = "dropoff_mileage")
    private int dropoffMileage;

    @Column(columnDefinition = "varchar(25) default 'AVAILABLE'")
    private ReservationStatus status;

    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "employee_id")
    private Long employeeId;

}
