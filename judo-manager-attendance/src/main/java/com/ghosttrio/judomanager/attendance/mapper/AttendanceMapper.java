package com.ghosttrio.judomanager.attendance.mapper;

import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity.AttendanceEntity;
import com.ghosttrio.judomanager.attendance.domain.AttendanceDomain;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper {

    public AttendanceDomain toDomain(AttendanceEntity attendanceEntity) {
        return AttendanceDomain.create(
                attendanceEntity.getUserId(),
                attendanceEntity.getDojoId(),
                attendanceEntity.getAttendanceTime()
        );
    }
}
