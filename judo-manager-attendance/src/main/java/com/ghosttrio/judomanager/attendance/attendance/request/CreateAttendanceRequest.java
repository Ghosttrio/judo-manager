package com.ghosttrio.judomanager.attendance.attendance.request;

public record CreateAttendanceRequest(
        Long dojoId,
        double latitude,
        double longitude
) {
}
