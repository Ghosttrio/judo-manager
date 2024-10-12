package com.ghosttrio.judomanager.attendance.attendance;

import com.ghosttrio.judomanager.attendance.attendance.request.CreateAttendanceRequest;
import com.judomanager.api.security.UserId;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.attendance.service.CreateAttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendances")
@Tag(name = "[Attendance API]")
public class CreateAttendanceController {

    private final CreateAttendanceService createAttendanceService;

    @PostMapping
    @Operation(summary = "유저가 출석 정보를 생성합니다.")
    public JMResponse<Void> createAttendance(@UserId Long userId,
                                             @RequestBody CreateAttendanceRequest request){
        createAttendanceService.create(userId, request.dojoId(), request.latitude(), request.longitude());
        return JMResponse.ok();
    }

}
