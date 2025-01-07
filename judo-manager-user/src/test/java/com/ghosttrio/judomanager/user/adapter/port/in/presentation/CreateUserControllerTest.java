package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request.UserRequest;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole;
import com.ghosttrio.judomanager.user.application.port.in.CreateUserUseCase;
import com.ghosttrio.judomanager.user.common.MonkeySupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole.MASTER;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CreateUserControllerTest extends MonkeySupport {

    @InjectMocks
    private CreateUserController createUserController;
    @Mock
    private CreateUserUseCase createUserUseCase;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(createUserController).build();
    }

    @Test
    @DisplayName("회원가입 성공 테스트")
    void 회원가입이_성공해야_한다() throws Exception {
        UserRequest.Create request = monkey.giveMeOne(UserRequest.Create.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users/signup")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}