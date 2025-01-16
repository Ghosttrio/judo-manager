package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghosttrio.judomanager.user.application.port.in.WithdrawUseCase;
import com.ghosttrio.judomanager.user.common.MonkeySupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class DeleteUserControllerTest extends MonkeySupport {

    @Mock
    private WithdrawUseCase withdrawUseCase;
    @InjectMocks
    private DeleteUserController deleteUserController;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(deleteUserController).build();
    }

    @Test
    void 유저_정보_삭제_요청이_성공해야_한다() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/auth/withdraw/" + 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}