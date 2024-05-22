package com.judomanager.api.presentation.dojo.request;

import java.time.LocalDateTime;

public record CreateLessonRequest(
        String name,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Long dojoId
) {
}
