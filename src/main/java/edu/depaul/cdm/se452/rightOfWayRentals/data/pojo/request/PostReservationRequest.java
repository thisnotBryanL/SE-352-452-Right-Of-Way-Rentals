package edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostReservationRequest {
    private final Long customerId;
    private final Long vehicleId;
    private final LocalDateTime pickup;
    private final Integer numberWeeks;
    private final Integer numberDays;
    private final String dropOffTime;
}
