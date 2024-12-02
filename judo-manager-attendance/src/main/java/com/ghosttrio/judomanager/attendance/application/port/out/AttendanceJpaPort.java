package com.ghosttrio.judomanager.attendance.application.port.out;

import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity.AttendanceEntity;
import com.ghosttrio.judomanager.attendance.domain.Attendance;

import java.util.Optional;

public interface AttendanceJpaPort {
    void save(AttendanceEntity attendanceEntity);

    Optional<Attendance> findAttendanceByUserId(Long userId);

    Double checkLocation(Double dojoLatitude, Double dojoLongitude, Double latitude, Double longitude);
}
