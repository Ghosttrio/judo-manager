package com.judomanager.api.dto.schedule;


public record CreateScheduleRequest(
        Long dojoId,
        String title,
        String content
){
}
