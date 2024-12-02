package com.ghosttrio.judomanager.schedule.schedule.adapter.port.out.jpa.repository;

import com.ghosttrio.judomanager.schedule.schedule.domain.QSchedule;
import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;



@RequiredArgsConstructor
public class ScheduleQueryRepositoryImpl implements ScheduleQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<Schedule> findScheduleByDojoId(Long dojoId) {
        return query.selectFrom(QSchedule.schedule)
                .where(QSchedule.schedule.dojoId.eq(dojoId))
                .fetch();
    }

    @Override
    public List<Schedule> findScheduleByDojoIdWeek(Long dojoId) {

        LocalDate today = LocalDate.now();

        // 이번 주 월요일의 날짜 구하기
        LocalDate startDate = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        // 이번 주 일요일의 날짜 구하기
        LocalDate endDate = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        return query.selectFrom(QSchedule.schedule)
                .where(QSchedule.schedule.dojoId.eq(dojoId)
                        .and(QSchedule.schedule.time.between(startDate.atStartOfDay(), endDate.atTime(LocalTime.MAX))))
                .fetch();
    }

    @Override
    public Optional<Schedule> findSchedule(Long scheduleId) {
        return Optional.ofNullable(query.selectFrom(QSchedule.schedule)
                .where(QSchedule.schedule.id.eq(scheduleId))
                .fetchOne());
    }
}
