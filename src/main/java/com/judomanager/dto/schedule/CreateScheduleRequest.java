package com.judomanager.dto.schedule;


public record CreateScheduleRequest(
        Long dojoId,
        String title,
        String content
){
}
