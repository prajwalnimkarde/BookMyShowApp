package com.cfs.bms.dto;

import com.cfs.bms.model.Payment;
import com.cfs.bms.model.Show;
import com.cfs.bms.model.ShowSeat;
import com.cfs.bms.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Long id;
    private String bookingNumber;
    private LocalDateTime bookingTime;
    private ShowDto show;
    private UserDto user;
    private String status;      // Confirmed, Cancelled, Pending
    private Double totalAmount;
    private List<ShowSeatDto> seats;
    private PaymentDto payment;
}
