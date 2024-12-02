package com.ghosttrio.judomanager.schedule.schedule.application.service;

import com.ghosttrio.judomanager.schedule.schedule.application.port.out.ScheduleJpaPort;
import com.ghosttrio.judomanager.schedule.schedule.common.exception.ErrorCode;
import com.ghosttrio.judomanager.schedule.schedule.common.exception.JMException;
import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoadScheduleService {

    private final ScheduleJpaPort scheduleJpaPort;

    public List<Schedule> findAllByDojoId(Long dojoId){
        return scheduleJpaPort.findScheduleByDojoId(dojoId);
    }

    public List<Schedule> findAllByDojoIdWeek(Long dojoId){
        return scheduleJpaPort.findScheduleByDojoIdWeek(dojoId);
    }

    public Schedule findSchedule(Long scheduleId){
        return scheduleJpaPort.findSchedule(scheduleId)
                .orElseThrow(() -> new JMException(ErrorCode.SCHEDULE_NOT_FOUND));
    }

}
