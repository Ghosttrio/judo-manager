package com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.repository;

import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity.AttendanceEntity;

import java.util.Optional;

public interface AttendanceQueryRepository {

    Double checkLocation(Double dojoLatitude, Double dojoLongitude, Double userLatitude, Double userLongitude);

    Optional<AttendanceEntity> findAttendanceByUserId(Long userId);
}
