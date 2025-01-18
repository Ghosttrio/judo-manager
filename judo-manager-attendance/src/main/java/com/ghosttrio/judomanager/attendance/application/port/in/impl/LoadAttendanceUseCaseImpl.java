package com.ghosttrio.judomanager.attendance.application.port.in.impl;

import com.ghosttrio.judomanager.attendance.application.port.in.LoadAttendanceUseCase;
import com.ghosttrio.judomanager.attendance.application.service.LoadAttendanceService;
import com.ghosttrio.judomanager.attendance.domain.AttendanceDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoadAttendanceUseCaseImpl implements LoadAttendanceUseCase {

    private final LoadAttendanceService loadAttendanceService;

    @Override
    public AttendanceDomain execute(Long userId) {
        return loadAttendanceService.loadAttendance(userId);
    }
}
