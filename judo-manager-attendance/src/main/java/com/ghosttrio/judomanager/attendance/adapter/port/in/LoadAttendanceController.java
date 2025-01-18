package com.ghosttrio.judomanager.attendance.adapter.port.in;

import com.ghosttrio.judomanager.attendance.application.port.in.LoadAttendanceUseCase;
import com.ghosttrio.judomanager.attendance.common.exception.JMResponse;
import com.ghosttrio.judomanager.attendance.domain.AttendanceDomain;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendances")
@Tag(name = "[Attendance API]")
public class LoadAttendanceController {

    private final LoadAttendanceUseCase loadAttendanceUseCase;

    @GetMapping
    @Operation(summary = "유저의 출석 정보를 불러옵니다.")
    public JMResponse<AttendanceDomain> loadUserAttendance(@RequestParam Long userId){
        AttendanceDomain attendanceDomain = loadAttendanceUseCase.execute(userId);
        return JMResponse.ok(attendanceDomain);
    }



}
