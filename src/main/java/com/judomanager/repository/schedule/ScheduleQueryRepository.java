package com.judomanager.repository.schedule;


import com.judomanager.domain.schedule.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleQueryRepository {

    List<Schedule> findScheduleByDojoId(Long dojoId);

    Optional<Schedule> findSchedule(Long scheduleId);
}
