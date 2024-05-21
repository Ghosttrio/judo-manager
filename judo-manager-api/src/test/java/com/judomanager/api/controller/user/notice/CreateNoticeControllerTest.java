//package com.judomanager.api.controller.user.notice;
//
//import com.judomanager.config.ControllerTestSupport;
//import com.judomanager.dto.notice.request.CreateNoticeRequest;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//class CreateNoticeControllerTest extends ControllerTestSupport {
//
//    /**
//     * TESTCASE
//     * 1. 공지사항 생성 요청 성공
//     */
//    @Test
//    @DisplayName("공지사항 생성 요청 성공")
//    void createNoticeSuccess() throws Exception {
//        Long dojoId = monkey.giveMeOne(Long.class);
//        CreateNoticeRequest request = monkey.giveMeOne(CreateNoticeRequest.class);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/notices/" + dojoId)
//                .content(objectMapper.writeValueAsString(request))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//}