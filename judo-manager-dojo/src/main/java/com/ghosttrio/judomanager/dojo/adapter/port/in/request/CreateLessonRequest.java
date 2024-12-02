package com.ghosttrio.judomanager.dojo.adapter.port.in.request;

import java.time.LocalDateTime;

public record CreateLessonRequest(
        String name,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Long dojoId
) {
}
