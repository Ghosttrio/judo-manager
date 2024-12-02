package com.ghosttrio.judomanager.payment.adapter.port.in;

import com.ghosttrio.judomanager.payment.adapter.port.out.feign.tosspayments.TosspaymentsFeignClient;
import com.ghosttrio.judomanager.payment.common.exception.JMResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class ApprovalPaymentController {

    private final TosspaymentsFeignClient tosspaymentsFeignClient;
    private final TossPaymentProperties tossPaymentProperties;

    private void savePaymentInfo(ConfirmRequest request) {
    }

    private String generateToken() {
        String widgetSecretKey = tossPaymentProperties.getSecret_key();
        System.out.println(widgetSecretKey);
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode((widgetSecretKey + ":").getBytes(StandardCharsets.UTF_8));
        return "Basic " + new String(encodedBytes);
    }

    @PostMapping("/confirm")
    public JMResponse<ConfirmRequest> confirmPayment(@RequestBody ConfirmRequest request) {
        savePaymentInfo(request);

        System.out.println(generateToken());
        Object result = tosspaymentsFeignClient.confirm(generateToken(), "application/json", new ConfirmRequest(request.getPaymentKey(), request.getOrderId(), request.amount));
        System.out.println(result);
        return JMResponse.ok(new ConfirmRequest("test", "Test", "test"));
    }

    @Data
    @AllArgsConstructor
    public static class ConfirmRequest {
        private String paymentKey;
        private String orderId;
        private String amount;
    }
}
