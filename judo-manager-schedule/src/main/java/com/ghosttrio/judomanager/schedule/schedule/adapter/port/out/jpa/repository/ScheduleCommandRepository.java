package com.ghosttrio.judomanager.schedule.schedule.adapter.port.out.jpa.repository;

public interface ScheduleCommandRepository {
    void update(Long scheduleId, String title, String content);
}
