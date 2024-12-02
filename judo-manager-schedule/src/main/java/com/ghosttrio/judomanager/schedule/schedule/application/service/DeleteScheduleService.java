package com.ghosttrio.judomanager.schedule.schedule.application.service;

import com.ghosttrio.judomanager.schedule.schedule.application.port.out.ScheduleJpaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeleteScheduleService {

    private final ScheduleJpaPort scheduleJpaPort;

    @Transactional
    public void delete(Long scheduleId){
        scheduleJpaPort.deleteById(scheduleId);
    }
}
