package com.example.paymentservice.PaymentGateways;

import org.springframework.stereotype.Service;

@Service
public class StripePaymentGW implements PaymentGateway{
    @Override
    public String generatePaymentLink(String orderId, String email, String phoneNumber, Long amount) {
        return null;
    }
}
