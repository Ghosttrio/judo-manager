package com.ghosttrio.judomanager.admin.adapter.port.in;

import com.ghosttrio.judomanager.admin.application.port.in.user.LoadUserUseCase;
import com.ghosttrio.judomanager.admin.application.port.in.user.UserBanUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private LoadUserUseCase loadUserUseCase;
    @Mock
    private UserBanUseCase userBanUseCase;
    @InjectMocks
    private UserController userController;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void 모든_회원_조회_요청이_성공해야_한다() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/admins/users"))
                .andExpect(status().isOk());
    }

    @Test
    void 유저_벤_요청이_성공해야_한다() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/admins/users/" + 1L))
                .andExpect(status().isOk());
    }
}