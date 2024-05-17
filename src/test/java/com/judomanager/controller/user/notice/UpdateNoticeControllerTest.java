package com.judomanager.controller.user.notice;

import com.judomanager.config.ControllerTestSupport;
import com.judomanager.dto.notice.request.UpdateNoticeRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UpdateNoticeControllerTest extends ControllerTestSupport {

    @Test
    @DisplayName("공지사항 업데이트")
    void updateNotice() throws Exception {
        Long noticeId = monkey.giveMeOne(Long.class);
        UpdateNoticeRequest request = monkey.giveMeOne(UpdateNoticeRequest.class);

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/notices/" + noticeId)
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}