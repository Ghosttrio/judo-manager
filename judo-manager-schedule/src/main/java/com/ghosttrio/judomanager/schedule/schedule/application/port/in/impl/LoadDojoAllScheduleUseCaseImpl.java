package com.ghosttrio.judomanager.schedule.schedule.application.port.in.impl;

import com.ghosttrio.judomanager.schedule.schedule.application.port.in.LoadDojoAllScheduleUseCase;
import com.ghosttrio.judomanager.schedule.schedule.application.service.LoadScheduleService;
import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LoadDojoAllScheduleUseCaseImpl implements LoadDojoAllScheduleUseCase {

    private final LoadScheduleService loadScheduleService;

    @Override
    public List<Schedule> execute(Long dojoId) {
        return loadScheduleService.findAllByDojoId(dojoId);
    }
}
