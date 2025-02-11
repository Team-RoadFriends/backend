package com.road_friends.rentalcar.controller;

import com.road_friends.rentalcar.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    //예약 추가 폼

    //예약 추가 처리

    //예약 수정 처리

    //예약 취소
}
