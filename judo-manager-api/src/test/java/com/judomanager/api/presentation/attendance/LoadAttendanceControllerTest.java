package com.judomanager.api.presentation.attendance;

import com.judomanager.api.config.ApiTest;
import com.judomanager.api.config.ControllerTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LoadAttendanceControllerTest extends ControllerTestSupport {

    @Test
    @ApiTest
    @DisplayName("회원의 출석정보를 출력하는 API가 성공한다.")
    void loadUserAttendanceTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/attendances"))
                .andExpect(status().isOk());
    }

}