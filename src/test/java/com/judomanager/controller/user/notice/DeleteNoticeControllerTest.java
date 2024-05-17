package com.judomanager.controller.user.notice;

import com.judomanager.config.ControllerTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DeleteNoticeControllerTest extends ControllerTestSupport {

    @Test
    @DisplayName("공지사항 삭제")
    void deleteNotice() throws Exception {
        Long noticeId = monkey.giveMeOne(Long.class);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/notices/" + noticeId))
                .andExpect(status().isOk());
    }
}