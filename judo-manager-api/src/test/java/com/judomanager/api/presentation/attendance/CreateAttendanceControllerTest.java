package com.judomanager.api.presentation.attendance;

import com.judomanager.api.config.ControllerTestSupport;
import com.judomanager.api.config.ApiTest;
import com.judomanager.api.presentation.attendance.request.CreateAttendanceRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CreateAttendanceControllerTest extends ControllerTestSupport {

    @Test
    @ApiTest
    @DisplayName("유저의 출석 생성 API 요청이 성공한다.")
    void createAttendance() throws Exception {
        CreateAttendanceRequest request = monkey.giveMeOne(CreateAttendanceRequest.class);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/attendances")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

}
