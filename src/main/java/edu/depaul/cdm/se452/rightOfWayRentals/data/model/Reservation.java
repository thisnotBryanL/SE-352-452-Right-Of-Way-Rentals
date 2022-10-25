package edu.depaul.cdm.se452.rightOfWayRentals.data.model;

import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.ReservationStatus;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public static Reservation newReservation(Customer customer, Vehicle vehicle, String pickupTime, String dropOffTime){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
        LocalDateTime localPickUpdate = LocalDateTime.parse(pickupTime , dtf);
        LocalDateTime localDropOffDate = LocalDateTime.parse(dropOffTime, dtf);

        var reservation = Reservation.builder()
                .customer(customer)
                .vehicle(vehicle)
                .status(ReservationStatus.RESERVED)
                .pickupMileage(vehicle.getMileage())
                .dropoffMileage(vehicle.getMileage()) // will need to include method for starting reservation / ending reservation
                .pickup(localPickUpdate)
                .dropoff(localDropOffDate) // TODO : based on number of weeks / days / and dropoff time ("09:08 AM"), add this to the pickup LocalDateTime
                .build();

        return reservation;
    }
}
