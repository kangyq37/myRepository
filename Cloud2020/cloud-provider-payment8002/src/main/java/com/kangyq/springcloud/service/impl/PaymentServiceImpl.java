package com.kangyq.springcloud.service.impl;

import com.kangyq.springcloud.entities.Payment;
import com.kangyq.springcloud.mapper.PaymentMapper;
import com.kangyq.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long Id) {
        return paymentMapper.getPaymentById(Id);
    }
}
