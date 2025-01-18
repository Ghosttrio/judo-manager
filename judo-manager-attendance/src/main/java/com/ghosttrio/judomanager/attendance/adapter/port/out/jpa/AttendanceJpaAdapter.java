package com.ghosttrio.judomanager.attendance.adapter.port.out.jpa;

import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity.AttendanceEntity;
import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.repository.AttendanceRepository;
import com.ghosttrio.judomanager.attendance.application.port.out.AttendanceJpaPort;
import com.ghosttrio.judomanager.attendance.domain.AttendanceDomain;
import com.ghosttrio.judomanager.attendance.mapper.AttendanceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AttendanceJpaAdapter implements AttendanceJpaPort {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;

    @Override
    public void save(AttendanceEntity attendanceEntity) {
        attendanceRepository.save(attendanceEntity);
    }

    @Override
    public Optional<AttendanceDomain> findAttendanceByUserId(Long userId) {
        Optional<AttendanceEntity> attendanceEntity = attendanceRepository.findAttendanceByUserId(userId);
        return attendanceEntity.map(attendanceMapper::toDomain);
    }

    @Override
    public Double checkLocation(Double dojoLatitude, Double dojoLongitude, Double latitude, Double longitude) {
        return attendanceRepository.checkLocation(dojoLatitude, dojoLongitude, latitude, longitude);
    }
}
