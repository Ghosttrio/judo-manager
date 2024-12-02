package com.ghosttrio.judomanager.attendance.adapter.port.in.request;

public record CreateAttendanceRequest(
        Long userId,
        Long dojoId,
        double latitude,
        double longitude
) {
}
