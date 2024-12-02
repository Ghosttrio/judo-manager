package com.ghosttrio.judomanager.schedule.schedule.application.port.out;

import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleJpaPort {
    void save(Schedule schedule);
    void deleteById(Long scheduleId);
    List<Schedule> findScheduleByDojoId(Long dojoId);
    List<Schedule> findScheduleByDojoIdWeek(Long dojoId);
    Optional<Schedule> findSchedule(Long scheduleId);
    void update(Long scheduleId, String title, String content);
}
