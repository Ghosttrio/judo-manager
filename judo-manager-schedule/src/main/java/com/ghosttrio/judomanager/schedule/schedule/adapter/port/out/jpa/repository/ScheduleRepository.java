package com.ghosttrio.judomanager.schedule.schedule.adapter.port.out.jpa.repository;


import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleQueryRepository, ScheduleCommandRepository {
}
