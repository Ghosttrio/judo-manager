package com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.repository;


import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long>, AttendanceQueryRepository {
}
