package com.judomanager.api.dto.attendance;

public record CreateAttendanceRequest(
        Long dojoId,
        double latitude,
        double longitude
) {
}
