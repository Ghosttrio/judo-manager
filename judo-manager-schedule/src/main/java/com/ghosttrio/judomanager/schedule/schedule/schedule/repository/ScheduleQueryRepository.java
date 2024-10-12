package com.ghosttrio.judomanager.schedule.schedule.schedule.repository;




import com.ghosttrio.judomanager.schedule.schedule.schedule.domain.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleQueryRepository {

    List<Schedule> findScheduleByDojoId(Long dojoId);

    List<Schedule> findScheduleByDojoIdWeek(Long dojoId);

    Optional<Schedule> findSchedule(Long scheduleId);
}
