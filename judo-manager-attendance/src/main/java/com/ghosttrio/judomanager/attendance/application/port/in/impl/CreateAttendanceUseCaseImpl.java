package com.ghosttrio.judomanager.attendance.application.port.in.impl;

import com.ghosttrio.judomanager.attendance.application.port.in.CreateAttendanceUseCase;
import com.ghosttrio.judomanager.attendance.application.service.CreateAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAttendanceUseCaseImpl implements CreateAttendanceUseCase {

    private final CreateAttendanceService createAttendanceService;

    @Override
    public void execute(Long userId, Long dojoId, Double latitude, Double longitude) {
        createAttendanceService.create(userId, dojoId, latitude, longitude);
    }
}
