package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import com.ghosttrio.judomanager.user.application.port.in.LoadUserUseCase;
import com.ghosttrio.judomanager.user.common.MonkeySupport;
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
class LoadUserControllerTest extends MonkeySupport {

    @Mock
    private LoadUserUseCase loadUserUseCase;
    @InjectMocks
    private LoadUserController loadUserController;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(loadUserController).build();
    }

    @Test
    void 회원단건조회_요청이_성공해야_한다() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/" + 1L))
                .andExpect(status().isOk());
    }
}