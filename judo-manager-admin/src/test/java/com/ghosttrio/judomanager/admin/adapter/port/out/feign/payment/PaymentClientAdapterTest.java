package com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment.model.Payment;
import com.ghosttrio.judomanager.admin.common.MonkeySupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentClientAdapterTest extends MonkeySupport {

    @InjectMocks
    private PaymentClientAdapter paymentClientAdapter;
    @Mock
    private PaymentFeignClient paymentFeignClient;

    @Test
    void 결제_정보_전체_요청이_성공해야_한다() {
        List<Payment> payments = monkey.giveMe(Payment.class, 3);
        when(paymentFeignClient.findAll()).thenReturn(payments);
        paymentClientAdapter.findAll();
        verify(paymentFeignClient, times(1)).findAll();
    }

}