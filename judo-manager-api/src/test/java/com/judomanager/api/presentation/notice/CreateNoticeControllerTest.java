package com.judomanager.api.presentation.notice;

import com.judomanager.api.config.ControllerTestSupport;
import com.judomanager.api.config.ApiTest;
import com.judomanager.api.presentation.notice.request.CreateNoticeRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CreateNoticeControllerTest extends ControllerTestSupport {

    /**
     * TESTCASE
     * 1. 공지사항 생성 요청 성공
     */
    @Test
    @ApiTest
    @DisplayName("공지사항 생성 API 요청이 성공한다.")
    void createNoticeSuccess() throws Exception {
        Long dojoId = monkey.giveMeOne(Long.class);
        CreateNoticeRequest request = monkey.giveMeOne(CreateNoticeRequest.class);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/notices/" + dojoId)
                        .with(csrf())
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}