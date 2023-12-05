package com.example.paymentservice.service;

import com.example.paymentservice.PaymentGateways.PaymentGWStrategyChooser;
import com.example.paymentservice.PaymentGateways.PaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentGWStrategyChooser paymentGWStrategyChooser;
    public String intialtePayment(String orderId, String email, String phoneNumber, Long amount){
      PaymentGateway paymentGateway= paymentGWStrategyChooser.getBestPaymentGw();

      return paymentGateway.generatePaymentLink(orderId, email, phoneNumber, amount);
    }
}
