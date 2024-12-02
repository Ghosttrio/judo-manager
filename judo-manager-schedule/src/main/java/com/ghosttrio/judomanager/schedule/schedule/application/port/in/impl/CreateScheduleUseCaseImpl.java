package com.ghosttrio.judomanager.schedule.schedule.application.port.in.impl;

import com.ghosttrio.judomanager.schedule.schedule.application.port.in.CreateScheduleUseCase;
import com.ghosttrio.judomanager.schedule.schedule.application.service.CreateScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CreateScheduleUseCaseImpl implements CreateScheduleUseCase {

    private final CreateScheduleService createScheduleService;

    @Override
    public void execute(Long dojoId, String title, String content, LocalDateTime startTime) {
        createScheduleService.create(dojoId, title, content, startTime);
    }
}
