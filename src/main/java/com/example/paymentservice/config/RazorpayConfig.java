package com.example.paymentservice.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${rezorpay.key.secret}")
    private String razorpayKeySecret;

    @Bean
    public RazorpayClient createRazorpayClient() throws RazorpayException{
        return new RazorpayClient(razorpayKeyId,razorpayKeySecret);
    }
}
