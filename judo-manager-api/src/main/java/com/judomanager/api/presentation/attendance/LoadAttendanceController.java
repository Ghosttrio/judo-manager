package com.judomanager.api.presentation.attendance;

import com.judomanager.api.security.UserId;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.attendance.domain.Attendance;
import com.judomanager.domain.attendance.service.LoadAttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendances")
@Tag(name = "[Attendance API]")
public class LoadAttendanceController {

    private final LoadAttendanceService loadAttendanceService;

    @GetMapping
    @Operation(summary = "유저의 출석 정보를 불러옵니다.")
    public JMResponse<Attendance> loadUserAttendance(@UserId Long userId){
        Attendance attendance = loadAttendanceService.loadAttendance(userId);
        return JMResponse.ok(attendance);
    }

}
