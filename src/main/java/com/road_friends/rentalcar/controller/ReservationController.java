package com.road_friends.rentalcar.controller;

import com.road_friends.rentalcar.dto.CarDto;
import com.road_friends.rentalcar.dto.ReservationDto;
import com.road_friends.rentalcar.service.CarService;
import com.road_friends.rentalcar.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    private CarService carService;

    //차량 목록 조회
    @GetMapping("/list")
    public String listCar(Model model){
        model.addAttribute("cars",reservationService.getAllCars());
        return "reservation/car_list";
    }

    //예약 목록 조회
    @GetMapping
    public String listReservations(Model model){
        model.addAttribute("reservations",reservationService.getAllReservations());
        return "reservation/list"; //Thymeleaf 템플릿 (reservation/list.html)
    }

    //예약 세부 조회
    @GetMapping("/show/{id}")
    public String showReservationDetails(@PathVariable Long id, Model model){
        ReservationDto reservation = reservationService.getReservationById(id);
        if(reservation == null) {
            return "redirect:/reservations";
        }
        model.addAttribute("reservation", reservation);
        return "reservation/show";
    }

    //예약 추가 폼
    @GetMapping("/new/{id}")
    public String showAddForm(@PathVariable int id, Model model, ReservationDto reservation){
        CarDto car = reservationService.getCarById(id);
        if(car == null){
            return "redirect:/reservations/car_list";
        }
        model.addAttribute("car", car);
        model.addAttribute("reservation",reservation);
        reservation.setCarId(id); //carId reservation에 지정
        return "reservation/new";
    }

    //예약 추가 처리
    @PostMapping
    public String addReservation(Model model, @ModelAttribute ReservationDto reservation){
        reservationService.newReservation(reservation);
        return "redirect:/reservations";
    }

    //예약 수정 폼
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        model.addAttribute("reservation", reservationService.getReservationById(id));
        return "reservation/sform";
    }

    //예약 수정 처리
    @PostMapping("/update")
    public String updateReservation(@ModelAttribute ReservationDto reservation){
        reservationService.updateReservation(reservation);
        return "redirect:/reservations";
    }

    //예약 취소(삭제)
    @GetMapping("/delete/{id}")
    public String deleteResevation(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return "redirect:/reservations";
    }
}
