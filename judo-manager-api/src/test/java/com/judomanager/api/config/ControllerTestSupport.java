//package com.judomanager.api.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.judomanager.controller.user.notice.CreateNoticeController;
//import com.judomanager.controller.user.notice.DeleteNoticeController;
//import com.judomanager.controller.user.notice.LoadNoticeController;
//import com.judomanager.controller.user.notice.UpdateNoticeController;
//import com.judomanager.service.notice.CreateNoticeService;
//import com.judomanager.service.notice.DeleteNoticeService;
//import com.judomanager.service.notice.LoadNoticeService;
//import com.judomanager.service.notice.UpdateNoticeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//
//
//@WebMvcTest(controllers = {
//        CreateNoticeController.class,
//        LoadNoticeController.class,
//        DeleteNoticeController.class,
//        UpdateNoticeController.class
//})
//@MockBean(JpaMetamodelMappingContext.class)
//@ActiveProfiles("test")
//@Import(SecurityTestConfig.class)
//public class ControllerTestSupport extends MonkeySupport {
//    @Autowired
//    WebApplicationContext context;
//    @Autowired
//    protected ObjectMapper objectMapper;
//    @Autowired
//    protected MockMvc mockMvc;
//    @MockBean
//    protected UpdateNoticeService updateNoticeService;
//    @MockBean
//    protected DeleteNoticeService deleteNoticeService;
//    @MockBean
//    protected CreateNoticeService createNoticeService;
//    @MockBean
//    protected LoadNoticeService loadNoticeService;
//}
