package com.ghosttrio.judomanager.schedule.schedule.application.service;

import com.ghosttrio.judomanager.schedule.schedule.application.port.out.ScheduleJpaPort;
import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UpdateScheduleService {

    private final ScheduleJpaPort scheduleJpaPort;

    @Transactional
    public void update(Long scheduleId, String title, String content){
        scheduleJpaPort.update(scheduleId, title, content);
    }

}
