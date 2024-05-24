package com.judomanager.api.presentation.attendance.dto;

public record CreateAttendanceRequest(
        Long dojoId,
        double latitude,
        double longitude
) {
}
