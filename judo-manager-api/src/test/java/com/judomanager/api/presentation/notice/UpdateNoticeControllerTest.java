package com.judomanager.api.presentation.notice;

import com.judomanager.api.config.ApiTest;
import com.judomanager.api.config.ControllerTestSupport;
import com.judomanager.api.presentation.notice.request.UpdateNoticeRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UpdateNoticeControllerTest extends ControllerTestSupport {

    @Test
    @ApiTest
    @DisplayName("공지사항 업데이트 API 요청이 성공한다.")
    void updateNotice() throws Exception {
        Long noticeId = monkey.giveMeOne(Long.class);
        UpdateNoticeRequest request = monkey.giveMeOne(UpdateNoticeRequest.class);

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/notices/" + noticeId)
                        .with(csrf())
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}