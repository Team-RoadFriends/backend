package com.road_friends.rentalcar.mapper;

import com.road_friends.rentalcar.dto.ReservationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    List<ReservationDto> findAll();
    ReservationDto findById(Long id);
    void update(ReservationDto reservation);
    void delete(Long id);
}
