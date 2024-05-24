package com.judomanager.domain.schedule.repository;

import com.judomanager.domain.schedule.domain.Schedule;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;

import static com.judomanager.domain.schedule.domain.QSchedule.schedule;


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
    public List<Schedule> findScheduleByDojoIdWeek(Long dojoId) {

        LocalDate today = LocalDate.now();

        // 이번 주 월요일의 날짜 구하기
        LocalDate startDate = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        // 이번 주 일요일의 날짜 구하기
        LocalDate endDate = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        return query.selectFrom(schedule)
                .where(schedule.dojoId.eq(dojoId)
                        .and(schedule.time.between(startDate.atStartOfDay(), endDate.atTime(LocalTime.MAX))))
                .fetch();
    }

    @Override
    public Optional<Schedule> findSchedule(Long scheduleId) {
        return Optional.ofNullable(query.selectFrom(schedule)
                .where(schedule.id.eq(scheduleId))
                .fetchOne());
    }
}
