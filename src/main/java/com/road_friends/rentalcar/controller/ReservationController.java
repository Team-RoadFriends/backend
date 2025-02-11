package com.road_friends.rentalcar.controller;

import com.road_friends.rentalcar.dto.ReservationDto;
import com.road_friends.rentalcar.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

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

    //예약 추가 처리

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
