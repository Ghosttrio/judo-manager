package com.judomanager.domain.payment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.judomanager.domain.payment.domain.Payment;
import com.judomanager.domain.payment.repository.PaymentRepository;
import com.judomanager.infrastructure.feign.tosspayments.client.TossFeignClient;
import com.judomanager.infrastructure.feign.tosspayments.dto.RequestDto;
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
    private final TossFeignClient tossFeignClient;

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public String loadPaymentWidget(String jsonBody) {
        String result = null;
        try {
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(jsonBody).getAsJsonObject();
            String orderId = json.get("orderId").getAsString();
            String amount = json.get("amount").getAsString();
            String paymentKey = json.get("paymentKey").getAsString();

            RequestDto build = RequestDto.builder()
                    .orderId(orderId)
                    .amount(amount)
                    .paymentKey(paymentKey)
                    .build();

            String authorizations = authorizationService.getAuthorization();
            Object sno = tossFeignClient.confirmPayment(authorizations, build);

            ObjectMapper mapper = new ObjectMapper();
            result = mapper.writeValueAsString(sno);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
