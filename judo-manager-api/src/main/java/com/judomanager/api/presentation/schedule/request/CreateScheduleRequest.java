package com.judomanager.api.presentation.schedule.request;


import java.time.LocalDateTime;

public record CreateScheduleRequest(
        Long dojoId,
        String title,
        String content,
        LocalDateTime startTime,
        LocalDateTime endTime
){
}
