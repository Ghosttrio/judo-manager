package com.ghosttrio.judomanager.attendance.application.port.in;

import com.ghosttrio.judomanager.attendance.domain.Attendance;

public interface LoadAttendanceUseCase {
    Attendance execute(Long userId);
}
