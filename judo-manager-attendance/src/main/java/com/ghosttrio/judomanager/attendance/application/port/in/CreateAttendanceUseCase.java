package com.ghosttrio.judomanager.attendance.application.port.in;

public interface CreateAttendanceUseCase {
    void execute(Long userId, Long dojoId, Double latitude, Double longitude);
}
