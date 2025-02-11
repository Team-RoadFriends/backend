package com.road_friends.rentalcar.controller;

import com.road_friends.rentalcar.dto.AdminInquiryDto;
import com.road_friends.rentalcar.service.AdminInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/inquiry")
public class AdminInquiryController {

    @Autowired
    AdminInquiryService adminInquiryService;

    // 관리자 질문 전체 조회
    @GetMapping
    public ResponseEntity<List<AdminInquiryDto>> getAllInquiry() {
        List<AdminInquiryDto> inquiry = adminInquiryService.getAllInquiry();
        return new ResponseEntity<>(inquiry, HttpStatus.OK);
    }

     // 관리자 질문 상세 조회
     @GetMapping("/{inquiryId}")
     public ResponseEntity<AdminInquiryDto> getInquiryById(@PathVariable("inquiryId") int inquiryId) {
         AdminInquiryDto inquiry = adminInquiryService.getInquiryById(inquiryId);
         return inquiry != null ? new ResponseEntity<>(inquiry, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }

     // 관리자 질문 답변 작성
     @PostMapping("/{inquiryId}/reply")
     public ResponseEntity<AdminInquiryDto> updateInquiryReply(@PathVariable("inquiryId") int inquiryId, @RequestBody AdminInquiryDto adminInquiryDto) {
         adminInquiryDto.setInquiryId(inquiryId);
         adminInquiryService.updateInquiryReply(adminInquiryDto);
         return new ResponseEntity<>(adminInquiryDto, HttpStatus.OK);
     }

     // 관리자 질문 답변 삭제
     @PostMapping("/{inquiryId}/reply/clear")
    public ResponseEntity<AdminInquiryDto> clearInquiryAnswer(@PathVariable("inquiryId") int inquiryId, @RequestBody AdminInquiryDto adminInquiryDto) {
        adminInquiryDto.setInquiryId(inquiryId);
        adminInquiryService.clearInquiryAnswer(adminInquiryDto);
        return new ResponseEntity<>(adminInquiryDto, HttpStatus.OK);
    }

     // 관리자 질문 삭제
     @DeleteMapping("/{inquiryId}")
     public ResponseEntity<Void> deleteInquiry(@PathVariable("inquiryId") int inquiryId) {
         adminInquiryService.deleteInquiry(inquiryId);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
    
}
