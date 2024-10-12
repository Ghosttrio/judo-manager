package com.ghosttrio.judomanager.schedule.schedule.schedule.service;

import com.ghosttrio.judomanager.schedule.schedule.schedule.domain.Schedule;
import com.judomanager.common.exception.ErrorCode;
import com.judomanager.common.exception.JMException;
import com.ghosttrio.judomanager.schedule.schedule.schedule.repository.ScheduleRepository;
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

    private final ScheduleRepository scheduleRepository;

    public List<Schedule> findAllByDojoId(Long dojoId){
        return scheduleRepository.findScheduleByDojoId(dojoId);
    }

    public List<Schedule> findAllByDojoIdWeek(Long dojoId){
        return scheduleRepository.findScheduleByDojoIdWeek(dojoId);
    }

    public Schedule findSchedule(Long scheduleId){
        return scheduleRepository.findSchedule(scheduleId)
                .orElseThrow(() -> new JMException(ErrorCode.SCHEDULE_NOT_FOUND));
    }

}
