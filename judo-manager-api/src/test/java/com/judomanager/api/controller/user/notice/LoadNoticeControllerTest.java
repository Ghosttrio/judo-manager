//package com.judomanager.api.controller.user.notice;
//
//import com.judomanager.config.ControllerTestSupport;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//class LoadNoticeControllerTest extends ControllerTestSupport {
//
//    @Test
//    @DisplayName("도장별 공지사항 목록 조회")
//    void loadAllNoticeByDojoId() throws Exception {
//        Long dojoId = monkey.giveMeOne(Long.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notices/" + dojoId))
//                .andExpect(status().isOk());
//    }
//
//}