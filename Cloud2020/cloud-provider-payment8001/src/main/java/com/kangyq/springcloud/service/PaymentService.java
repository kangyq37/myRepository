package com.kangyq.springcloud.service;

import com.kangyq.springcloud.entities.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long Id);
}
