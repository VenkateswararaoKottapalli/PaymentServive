package com.example.paymentservice.controller;

import com.example.paymentservice.dtos.IntiatePaymentDto;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
      @Autowired
      private PaymentService paymentService;
      @PostMapping("/")
      public String intialtePayment(@RequestBody IntiatePaymentDto intiatePaymentDto){
         return  paymentService.intialtePayment(
                    intiatePaymentDto.getOrderId(),
                    intiatePaymentDto.getEmail(),
                    intiatePaymentDto.getPhoneNumber(),
                    intiatePaymentDto.getAmount()
            );
      }
}