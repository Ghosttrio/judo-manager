package com.judomanager.api.presentation.notice;

import com.judomanager.api.config.ApiTest;
import com.judomanager.api.config.ControllerTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DeleteNoticeControllerTest extends ControllerTestSupport {

    @Test
    @ApiTest
    @DisplayName("공지사항 삭제 API 요청이 성공한다.")
    void deleteNotice() throws Exception {
        Long noticeId = monkey.giveMeOne(Long.class);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/notices/" + noticeId)
                        .with(csrf()))
                .andExpect(status().isOk());
    }
}