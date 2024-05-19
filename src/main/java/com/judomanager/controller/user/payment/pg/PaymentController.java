package com.judomanager.controller.user.payment.pg;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final AuthorizationService authorizationService;
    private final TossFeignClient tossFeignClient;

    @RequestMapping(value = "/confirm")
    public ResponseEntity<?> confirmPayment(@RequestBody String jsonBody) throws Exception {

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
        log.info("object : {}", sno);

        ObjectMapper mapper = new ObjectMapper();


        String result = mapper.writeValueAsString(sno);
        return ResponseEntity.ok(result);
    }
}