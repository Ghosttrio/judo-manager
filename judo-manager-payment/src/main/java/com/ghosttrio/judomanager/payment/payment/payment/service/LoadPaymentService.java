package com.ghosttrio.judomanager.payment.payment.payment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghosttrio.judomanager.payment.payment.payment.domain.Payment;
import com.ghosttrio.judomanager.payment.payment.payment.repository.PaymentRepository;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
        String result = null;
        try {

            JsonObject json = JsonParser.parseString(jsonBody).getAsJsonObject();
            String orderId = json.get("orderId").getAsString();
            String amount = json.get("amount").getAsString();
            String paymentKey = json.get("paymentKey").getAsString();

            TosspaymentConfirmRequest request = new TosspaymentConfirmRequest(orderId, amount, paymentKey);

            String authorizations = authorizationService.getAuthorization();
            Object sno = tosspaymentConfirmClient.confirmPayment(authorizations, request);

            ObjectMapper mapper = new ObjectMapper();
            result = mapper.writeValueAsString(sno);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
