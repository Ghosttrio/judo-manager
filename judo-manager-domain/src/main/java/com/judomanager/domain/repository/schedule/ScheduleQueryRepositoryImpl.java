package com.judomanager.domain.repository.schedule;

import com.judomanager.domain.domain.schedule.Schedule;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.judomanager.domain.domain.schedule.QSchedule.schedule;


@RequiredArgsConstructor
public class ScheduleQueryRepositoryImpl implements ScheduleQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<Schedule> findScheduleByDojoId(Long dojoId) {
        return query.selectFrom(schedule)
                .where(schedule.dojoId.eq(dojoId))
                .fetch();
    }

    @Override
    public Optional<Schedule> findSchedule(Long scheduleId) {
        return Optional.ofNullable(query.selectFrom(schedule)
                .where(schedule.id.eq(scheduleId))
                .fetchOne());
    }
}
