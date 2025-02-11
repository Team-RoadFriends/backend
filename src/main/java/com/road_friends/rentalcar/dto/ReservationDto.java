package com.road_friends.rentalcar.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDto {
    private int reservationSId;
    private int carId;

    //이용 시작날짜
    @JsonProperty("reservation_s_start_date")
    private LocalDateTime reservationSStartDate;

    //이용 종료날짜
    @JsonProperty("reservation_s_end_date")
    private LocalDateTime reservationSEndDate;

    //예약 생성 날짜
    @JsonProperty("reservation_s_create_date")
    private LocalDateTime reservationSCreateDate;

}

