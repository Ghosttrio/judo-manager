package com.ghosttrio.judomanager.attendance.adapter.port.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghosttrio.judomanager.attendance.adapter.port.in.request.CreateAttendanceRequest;
import com.ghosttrio.judomanager.attendance.application.port.in.CreateAttendanceUseCase;
import com.ghosttrio.judomanager.attendance.common.exception.JMResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendances")
@Tag(name = "[Attendance API]")
public class CreateAttendanceController {

	private final CreateAttendanceUseCase createAttendanceUseCase;

	@Operation(summary = "유저가 출석 정보를 생성합니다.")
	@PostMapping
	public JMResponse<Void> createAttendance(@RequestBody CreateAttendanceRequest request) {
		createAttendanceUseCase.execute(request.userId(), request.dojoId(), request.latitude(), request.longitude());
		return JMResponse.ok();
	}

}
