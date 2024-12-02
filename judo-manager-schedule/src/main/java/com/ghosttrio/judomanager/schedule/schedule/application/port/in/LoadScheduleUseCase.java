package com.ghosttrio.judomanager.schedule.schedule.application.port.in;

import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;

public interface LoadScheduleUseCase {
    Schedule execute(Long scheduleId);
}
