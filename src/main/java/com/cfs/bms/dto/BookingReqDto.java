package com.cfs.bms.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingReqDto {
    private Long userId;
    private Long showId;
    private List<Long> seatIds;
    private String paymentMethod;
}
