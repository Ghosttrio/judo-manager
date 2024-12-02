package com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.repository;

import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity.AttendanceEntity;
import com.ghosttrio.judomanager.attendance.domain.Attendance;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity.QAttendanceEntity.attendanceEntity;


@RequiredArgsConstructor
public class AttendanceQueryRepositoryImpl implements AttendanceQueryRepository {

    private final JPAQueryFactory query;


    @Override
    public Double checkLocation(Double dojoLatitude, Double dojoLongitude, Double userLatitude, Double userLongitude) {
        NumberExpression<Double> haversine = haversine(dojoLatitude, dojoLongitude, userLatitude, userLongitude);
        return query.select(haversine).fetchOne();
    }

    private NumberExpression<Double> haversine(Double dojoLatitude, Double dojoLongitude, Double userLatitude, Double userLongitude) {
        NumberExpression<Double> a =
                Expressions.numberTemplate(Double.class, "power(sin( (radians({0}) - radians({1})) / 2), 2)", dojoLatitude, userLatitude);
        NumberExpression<Double> b =
                Expressions.numberTemplate(Double.class, "cos(radians({0}))", userLatitude);
        NumberExpression<Double> c =
                Expressions.numberTemplate(Double.class, "cos(radians({0}))", dojoLatitude);
        NumberExpression<Double> d =
                Expressions.numberTemplate(Double.class, "power(sin( (radians({0}) - radians({1})) / 2), 2)", dojoLongitude, userLongitude);

        return Expressions.numberTemplate(Double.class, "(2 * 6371 * asin(sqrt({0})))", a.add(b.multiply(c).multiply(d)));
    }

    /**  */
    @Override
    public Optional<AttendanceEntity> findAttendanceByUserId(Long userId) {
        return Optional.ofNullable(
                query.selectFrom(attendanceEntity)
                .where(attendanceEntity.userId.eq(userId))
                .fetchOne());
    }

}
