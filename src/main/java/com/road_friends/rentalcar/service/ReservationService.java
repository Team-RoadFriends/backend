package com.road_friends.rentalcar.service;

import com.road_friends.rentalcar.dto.CarDto;
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

    public List<CarDto> getAllCars(){
        return reservationMapper.findCar();
    }

    public List<ReservationDto> getAllReservations() {
        return reservationMapper.findAll();
    }

    public CarDto getCarById(int id){
        return reservationMapper.findByCarId(id);
    }

    public void newReservation(ReservationDto reservation){
        reservationMapper.insert(reservation);
    }

    public ReservationDto getReservationById(Long id){
        return reservationMapper.findById(id);
    }

    public void updateReservation(ReservationDto reservation) {
        reservationMapper.update(reservation);
    }

    public void deleteReservation(Long id){
        reservationMapper.delete(id);
    }
}//END service
