package com.ghosttrio.judomanager.payment.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghosttrio.judomanager.payment.application.port.out.PaymentJpaPort;
import com.ghosttrio.judomanager.payment.domain.Payment;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoadPaymentService {

	private final PaymentJpaPort paymentJpaPort;
	//    private final AuthorizationService authorizationService;
	//    private final TosspaymentConfirmClient tosspaymentConfirmClient;

	public List<Payment> findAll() {
		return paymentJpaPort.findAll();
	}

	public String loadPaymentWidget(String jsonBody) {
		String result = null;
		//        try {
		//
		//            JsonObject json = JsonParser.parseString(jsonBody).getAsJsonObject();
		//            String orderId = json.get("orderId").getAsString();
		//            String amount = json.get("amount").getAsString();
		//            String paymentKey = json.get("paymentKey").getAsString();
		//
		//            TosspaymentConfirmRequest request = new TosspaymentConfirmRequest(orderId, amount, paymentKey);
		//
		//            String authorizations = authorizationService.getAuthorization();
		//            Object sno = tosspaymentConfirmClient.confirmPayment(authorizations, request);
		//
		//            ObjectMapper mapper = new ObjectMapper();
		//            result = mapper.writeValueAsString(sno);
		//        }catch (Exception e){
		//            e.printStackTrace();
		//        }
		return result;
	}
}
