package com.judomanager.api.presentation.attendance.controller;

import com.judomanager.api.security.UserId;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.attendance.domain.Attendance;
import com.judomanager.domain.attendance.service.LoadAttendanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendances")
@Tag(name = "출석 조회 컨트롤러")
public class LoadAttendanceController {

    private final LoadAttendanceService loadAttendanceService;

    // 유저의 출석 여부 확인
    // todo 이미 출석을 했으면 출석 x -> api 생성
    @GetMapping
    public JMResponse<Attendance> loadUserAttendance(@UserId Long userId){
        Attendance attendance = loadAttendanceService.loadAttendance(userId);
        return JMResponse.ok(attendance);
    }



}
