package edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostReservationRequest {
    private Long customerId;
    private Long vehicleId;
    private String pickup;
    private Integer numberWeeks;
    private Integer numberDays;
    private String dropOffTime;
}
