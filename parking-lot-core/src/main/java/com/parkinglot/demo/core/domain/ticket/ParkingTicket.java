package com.parkinglot.demo.core.domain.ticket;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ParkingTicket {

    private String id;

    private LocalDateTime startTime;

    private LocalDateTime payTime;

    /**
     * real paid fee
     */
    private Double paidFee;

    private ParkingTicket() {}

    public boolean isPaid() {
        return payTime != null;
    }

    public static ParkingTicket getTicket(LocalDateTime startTime) {
        ParkingTicket t = new ParkingTicket();
        t.id = UUID.randomUUID().toString();
        t.startTime = startTime;
        return t;
    }
}
