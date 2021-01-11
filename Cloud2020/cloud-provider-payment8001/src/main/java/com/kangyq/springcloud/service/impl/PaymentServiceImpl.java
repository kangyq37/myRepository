package com.kangyq.springcloud.service.impl;

import com.kangyq.springcloud.entities.Payment;
import com.kangyq.springcloud.mapper.PaymentMapper;
import com.kangyq.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long Id) {
        log.info("123");
        return paymentMapper.getPaymentById(Id);
    }
}
