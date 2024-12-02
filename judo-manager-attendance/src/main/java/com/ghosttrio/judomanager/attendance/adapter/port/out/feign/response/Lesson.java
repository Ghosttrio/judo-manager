package com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Lesson {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
