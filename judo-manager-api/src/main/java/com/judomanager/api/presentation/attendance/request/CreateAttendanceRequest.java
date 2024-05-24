package com.judomanager.api.presentation.attendance.request;

public record CreateAttendanceRequest(
        Long dojoId,
        double latitude,
        double longitude
) {
}
