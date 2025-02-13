package com.road_friends.rentalcar.mapper;

import com.road_friends.rentalcar.dto.CarDto;
import com.road_friends.rentalcar.dto.ReservationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    List<CarDto> findCar();
    List<ReservationDto> findAll();
    ReservationDto findById(Long id);
    CarDto findByCarId(int id);
    void insert(ReservationDto reservation);
    void update(ReservationDto reservation);
    void delete(Long id);
}
