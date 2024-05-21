package com.judomanager.domain.repository.schedule;

import com.judomanager.domain.domain.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleQueryRepository {
}
