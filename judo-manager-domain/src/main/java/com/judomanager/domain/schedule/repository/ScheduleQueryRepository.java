package com.judomanager.domain.schedule.repository;




import com.judomanager.domain.schedule.domain.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleQueryRepository {

    List<Schedule> findScheduleByDojoId(Long dojoId);

    Optional<Schedule> findSchedule(Long scheduleId);
}
