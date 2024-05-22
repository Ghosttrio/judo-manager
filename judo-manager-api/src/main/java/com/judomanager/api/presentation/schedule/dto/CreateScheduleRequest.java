package com.judomanager.api.presentation.schedule.dto;


public record CreateScheduleRequest(
        Long dojoId,
        String title,
        String content
){
}
