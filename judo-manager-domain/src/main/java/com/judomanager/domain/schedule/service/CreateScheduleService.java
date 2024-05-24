package com.judomanager.domain.schedule.service;

import com.judomanager.domain.schedule.domain.Schedule;
import com.judomanager.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void create(Long dojoId, String title, String content){
        Schedule schedule = Schedule.create(dojoId, title, content);
        scheduleRepository.save(schedule);
    }
}
