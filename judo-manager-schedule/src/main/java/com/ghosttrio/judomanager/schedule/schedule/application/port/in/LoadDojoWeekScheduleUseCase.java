package com.ghosttrio.judomanager.schedule.schedule.application.port.in;

import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;

import java.util.List;

public interface LoadDojoWeekScheduleUseCase {
    List<Schedule> execute(Long dojoId);
}
