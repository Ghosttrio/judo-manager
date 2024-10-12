package com.ghosttrio.judomanager.dojo.dojo.request;

import java.time.LocalDateTime;

public record CreateLessonRequest(
        String name,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Long dojoId
) {
}
