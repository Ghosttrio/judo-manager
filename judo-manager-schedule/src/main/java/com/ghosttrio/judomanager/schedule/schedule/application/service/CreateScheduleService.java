package com.ghosttrio.judomanager.schedule.schedule.application.service;

import com.ghosttrio.judomanager.schedule.schedule.application.port.out.ScheduleJpaPort;
import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateScheduleService {

    private final ScheduleJpaPort scheduleJpaPort;

    @Transactional
    public void create(Long dojoId, String title, String content, LocalDateTime startTime){
        Schedule schedule = Schedule.create(dojoId, title, content, startTime);
        scheduleJpaPort.save(schedule);
    }
}
