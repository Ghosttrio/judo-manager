package com.ghosttrio.judomanager.schedule.schedule.adapter.port.out.jpa;

import com.ghosttrio.judomanager.schedule.schedule.adapter.port.out.jpa.repository.ScheduleRepository;
import com.ghosttrio.judomanager.schedule.schedule.application.port.out.ScheduleJpaPort;
import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ScheduleJpaAdapter implements ScheduleJpaPort {

    private final ScheduleRepository scheduleRepository;

    @Override
    public void save(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public void deleteById(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }

    @Override
    public List<Schedule> findScheduleByDojoId(Long dojoId) {
        return scheduleRepository.findScheduleByDojoId(dojoId);
    }

    @Override
    public List<Schedule> findScheduleByDojoIdWeek(Long dojoId) {
        return scheduleRepository.findScheduleByDojoIdWeek(dojoId);
    }

    @Override
    public Optional<Schedule> findSchedule(Long scheduleId) {
        return scheduleRepository.findSchedule(scheduleId);
    }

    @Override
    public void update(Long scheduleId, String title, String content) {
        scheduleRepository.update(scheduleId, title, content);
    }

}
