package com.ghosttrio.judomanager.schedule.schedule.application.port.in;

import java.time.LocalDateTime;

public interface CreateScheduleUseCase {
    void execute(Long dojoId, String title, String content, LocalDateTime startTime);
}
