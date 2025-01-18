package com.ghosttrio.judomanager.attendance.application.port.in;

import com.ghosttrio.judomanager.attendance.domain.AttendanceDomain;

public interface LoadAttendanceUseCase {
    AttendanceDomain execute(Long userId);
}
