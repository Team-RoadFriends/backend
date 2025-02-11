package com.road_friends.rentalcar.service;

import com.road_friends.rentalcar.dto.ReservationDto;
import com.road_friends.rentalcar.mapper.ReservationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationMapper reservationMapper){
        this.reservationMapper = reservationMapper;
    }

    public List<ReservationDto> getAllReservations() {
        return reservationMapper.findAll();
    }

    public ReservationDto getReservationById(Long id){
        return reservationMapper.findById(id);
    }

    public void updateReservation(ReservationDto reservation) {
        reservationMapper.update(reservation);
    }
}//END service
