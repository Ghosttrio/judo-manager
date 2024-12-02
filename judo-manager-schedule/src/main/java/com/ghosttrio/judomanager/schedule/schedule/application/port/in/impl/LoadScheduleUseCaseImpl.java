package com.ghosttrio.judomanager.schedule.schedule.application.port.in.impl;

import com.ghosttrio.judomanager.schedule.schedule.application.port.in.LoadScheduleUseCase;
import com.ghosttrio.judomanager.schedule.schedule.application.service.LoadScheduleService;
import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class LoadScheduleUseCaseImpl implements LoadScheduleUseCase {

    private final LoadScheduleService loadScheduleService;

    @Override
    public Schedule execute(Long scheduleId) {
        return loadScheduleService.findSchedule(scheduleId);
    }
}
