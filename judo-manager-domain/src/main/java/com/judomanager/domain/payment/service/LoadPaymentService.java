package com.judomanager.domain.payment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.judomanager.domain.payment.domain.Payment;
import com.judomanager.domain.payment.repository.PaymentRepository;
import com.judomanager.infrastructure.feign.tosspayments.client.TosspaymentConfirmClient;
import com.judomanager.infrastructure.feign.tosspayments.dto.TosspaymentConfirmRequest;
import com.judomanager.infrastructure.feign.tosspayments.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoadPaymentService {

    private final PaymentRepository paymentRepository;
    private final AuthorizationService authorizationService;
    private final TosspaymentConfirmClient tosspaymentConfirmClient;

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public String loadPaymentWidget(String jsonBody) {
        // 페이먼츠 로직 추가
        return null;
    }
}
