package com.example.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class IntiatePaymentDto {
    private String email;
    private String phoneNumber;
    private Long amount;
    private String orderId;
}
