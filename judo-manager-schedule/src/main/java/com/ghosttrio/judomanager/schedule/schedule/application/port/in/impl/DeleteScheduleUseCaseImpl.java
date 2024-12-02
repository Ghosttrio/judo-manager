package com.ghosttrio.judomanager.schedule.schedule.application.port.in.impl;

import com.ghosttrio.judomanager.schedule.schedule.application.port.in.DeleteScheduleUseCase;
import com.ghosttrio.judomanager.schedule.schedule.application.service.DeleteScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteScheduleUseCaseImpl implements DeleteScheduleUseCase {

    private final DeleteScheduleService deleteScheduleService;

    @Override
    public void execute(Long scheduleId) {
        deleteScheduleService.delete(scheduleId);
    }
}
