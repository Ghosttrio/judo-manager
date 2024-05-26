package com.judomanager.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.judomanager.api.presentation.attendance.CreateAttendanceController;
import com.judomanager.api.presentation.attendance.LoadAttendanceController;
import com.judomanager.api.presentation.notice.CreateNoticeController;
import com.judomanager.api.presentation.notice.DeleteNoticeController;
import com.judomanager.api.presentation.notice.LoadNoticeController;
import com.judomanager.api.presentation.notice.UpdateNoticeController;
import com.judomanager.domain.attendance.service.CreateAttendanceService;
import com.judomanager.domain.attendance.service.LoadAttendanceService;
import com.judomanager.domain.notice.service.CreateNoticeService;
import com.judomanager.domain.notice.service.DeleteNoticeService;
import com.judomanager.domain.notice.service.LoadNoticeService;
import com.judomanager.domain.notice.service.UpdateNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


@WebMvcTest(controllers = {
        CreateNoticeController.class,
        DeleteNoticeController.class,
        LoadNoticeController.class,
        UpdateNoticeController.class,

        CreateAttendanceController.class,
        LoadAttendanceController.class
})
//@MockBean(JpaMetamodelMappingContext.class)
//@Import(SecurityTestConfig.class)
@ActiveProfiles("test")
public class ControllerTestSupport extends MonkeySupport {
    @Autowired
    WebApplicationContext context;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected CreateNoticeService createNoticeService;
    @MockBean
    protected DeleteNoticeService deleteNoticeService;
    @MockBean
    protected LoadNoticeService loadNoticeService;
    @MockBean
    protected UpdateNoticeService updateNoticeService;

    @MockBean
    protected CreateAttendanceService createAttendanceService;
    @MockBean
    protected LoadAttendanceService loadAttendanceService;
}
