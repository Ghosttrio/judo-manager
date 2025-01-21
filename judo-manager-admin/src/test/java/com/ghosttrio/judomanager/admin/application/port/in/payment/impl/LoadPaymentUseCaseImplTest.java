package com.ghosttrio.judomanager.admin.application.port.in.payment.impl;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment.model.Payment;
import com.ghosttrio.judomanager.admin.application.service.PaymentService;
import com.ghosttrio.judomanager.admin.common.MonkeySupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LoadPaymentUseCaseImplTest extends MonkeySupport {
    @InjectMocks
    private LoadPaymentUseCaseImpl loadPaymentUseCaseImpl;
    @Mock
    private PaymentService paymentService;

    @Test
    void 모든_결제_정보_조회_서비스가_호출되어야_한다() {
        List<Payment> payments = monkey.giveMe(Payment.class, 3);
        Mockito.when(paymentService.findAll()).thenReturn(payments);
        loadPaymentUseCaseImpl.execute();
        verify(paymentService, times(1)).findAll();
    }
}
