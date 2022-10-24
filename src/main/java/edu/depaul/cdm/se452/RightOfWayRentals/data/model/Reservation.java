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
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;

    @Column(name = "customer_id")
    private Long customerId;

}
