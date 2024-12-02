package com.ghosttrio.judomanager.schedule.schedule.adapter.port.out.jpa.repository;


import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleQueryRepository {

    List<Schedule> findScheduleByDojoId(Long dojoId);

    List<Schedule> findScheduleByDojoIdWeek(Long dojoId);

    Optional<Schedule> findSchedule(Long scheduleId);
}
