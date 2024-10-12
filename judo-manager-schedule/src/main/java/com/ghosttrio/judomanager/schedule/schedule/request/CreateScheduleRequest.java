package com.ghosttrio.judomanager.schedule.schedule.request;


import java.time.LocalDateTime;

public record CreateScheduleRequest(
        Long dojoId,
        String title,
        String content,
        LocalDateTime startTime,
        LocalDateTime endTime
){
}
