package com.ghosttrio.judomanager.attendance.mapper;

import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity.AttendanceEntity;
import com.ghosttrio.judomanager.attendance.domain.Attendance;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper {

    public Attendance toDomain(AttendanceEntity attendanceEntity) {
        return Attendance.create(
                attendanceEntity.getUserId(),
                attendanceEntity.getDojoId(),
                attendanceEntity.getAttendanceTime()
        );
    }
}
