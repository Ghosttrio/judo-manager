package com.ghosttrio.judomanager.attendance.domain.attendance.repository;


import com.judomanager.domain.attendance.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>, AttendanceQueryRepository {
}
