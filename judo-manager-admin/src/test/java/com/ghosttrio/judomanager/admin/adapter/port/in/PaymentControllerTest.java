package com.ghosttrio.judomanager.admin.adapter.port.in;

import com.ghosttrio.judomanager.admin.application.port.in.payment.LoadPaymentUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    @Mock
    private LoadPaymentUseCase loadPaymentUseCase;
    @InjectMocks
    private PaymentController paymentController;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    @Test
    void 모든_결제_내역_조회_요청이_성공해야_한다() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/admins/payments"))
                .andExpect(status().isOk());
    }
}