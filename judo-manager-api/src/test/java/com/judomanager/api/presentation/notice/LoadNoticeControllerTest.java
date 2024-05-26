package com.judomanager.api.presentation.notice;

import com.judomanager.api.config.ApiTest;
import com.judomanager.api.config.ControllerTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LoadNoticeControllerTest extends ControllerTestSupport {

    @Test
    @ApiTest
    @DisplayName("도장별 공지사항 목록 조회 API 요청이 성공한다.")
    void loadAllNoticeByDojoId() throws Exception {
        Long dojoId = monkey.giveMeOne(Long.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notices/" + dojoId).with(csrf()))
                .andExpect(status().isOk());
    }

}