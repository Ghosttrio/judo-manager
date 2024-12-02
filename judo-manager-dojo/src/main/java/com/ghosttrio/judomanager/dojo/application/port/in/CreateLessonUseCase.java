package com.ghosttrio.judomanager.dojo.application.port.in;

import java.time.LocalDateTime;

public interface CreateLessonUseCase {
    void execute(Long dojoId, String name, LocalDateTime startTime, LocalDateTime endTime);
}
