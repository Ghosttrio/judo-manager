package com.judomanager.api.presentation.user;


import com.judomanager.api.config.ControllerTestSupport;
import com.judomanager.api.config.SecurityTestConfig;
import com.judomanager.api.presentation.user.request.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SecurityTestConfig.class)
class LoginControllerTest extends ControllerTestSupport {

    @Test
    void login() throws Exception {
        LoginRequest request = monkey.giveMeOne(LoginRequest.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth/login")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void refresh() {

    }
}