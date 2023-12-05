package com.example.paymentservice.PaymentGateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentGWStrategyChooser {
    @Autowired
    private RazorpayPaymentGW razorPayPaymentGW;
    @Autowired
    private StripePaymentGW stripePaymentGW;

    public PaymentGateway getBestPaymentGw(){
        return razorPayPaymentGW;
    }

}
