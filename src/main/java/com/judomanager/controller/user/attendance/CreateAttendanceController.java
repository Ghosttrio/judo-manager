package com.judomanager.controller.user.attendance;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendance")
@Tag(name = "출석 생성 컨트롤러")
public class CreateAttendanceController {

//    @PostMapping
//    public JMResponse<Void> createAttendance(){
//
//    }
}
