package com.judomanager.dto.attendance;

public record CreateAttendanceRequest(
        Long dojoId,
        double latitude,
        double longitude
) {
}
