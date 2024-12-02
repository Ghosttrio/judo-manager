package com.ghosttrio.judomanager.schedule.schedule.adapter.port.out.jpa.repository;

import com.ghosttrio.judomanager.schedule.schedule.domain.QSchedule;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.ghosttrio.judomanager.schedule.schedule.domain.QSchedule.schedule;

@RequiredArgsConstructor
public class ScheduleCommandRepositoryImpl implements ScheduleCommandRepository {

    private final JPAQueryFactory query;

    @Override
    public void update(Long scheduleId, String title, String content) {
        query.update(schedule)
                .set(schedule.title, title)
                .set(schedule.content, content)
                .where(schedule.id.eq(scheduleId))
                .execute();
    }
}
