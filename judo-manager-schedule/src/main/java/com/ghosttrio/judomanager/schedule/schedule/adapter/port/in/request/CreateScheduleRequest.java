package com.ghosttrio.judomanager.schedule.schedule.adapter.port.in.request;


import java.time.LocalDateTime;

public record CreateScheduleRequest(
        Long dojoId,
        String title,
        String content,
        LocalDateTime startTime,
        LocalDateTime endTime
){
}
