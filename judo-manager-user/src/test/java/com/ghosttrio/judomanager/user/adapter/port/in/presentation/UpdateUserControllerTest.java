package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request.UserRequest;
import com.ghosttrio.judomanager.user.application.port.in.UpdateDojoUseCase;
import com.ghosttrio.judomanager.user.application.port.in.UpdateNicknameUseCase;
import com.ghosttrio.judomanager.user.application.port.in.UpdateUserStatusUseCase;
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
class UpdateUserControllerTest extends MonkeySupport {

    @Mock
    private UpdateNicknameUseCase updateNicknameUseCase;
    @Mock
    private UpdateDojoUseCase updateDojoUseCase;
    @Mock
    private UpdateUserStatusUseCase updateUserStatusUseCase;
    @InjectMocks
    private UpdateUserController updateUserController;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(updateUserController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void 닉네임_변경_요청이_성공해야_한다() throws Exception {
        UserRequest.Nickname request = monkey.giveMeOne(UserRequest.Nickname.class);
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/users/nickname/" + 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void 유저의_도장_정보변경_요청이_성공해야_한다() throws Exception {
        UserRequest.Dojo request = monkey.giveMeOne(UserRequest.Dojo.class);
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/users/" + 1L + "/dojo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void 유저의_상태_정보_변경_요청이_성공해야_한다() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/users/" + 1L + "/status"))
                .andExpect(status().isOk());
    }
}