package com.ghosttrio.judomanager.attendance.application.service;

import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.repository.AttendanceRepository;
import com.ghosttrio.judomanager.attendance.application.port.out.AttendanceJpaPort;
import com.ghosttrio.judomanager.attendance.common.exception.JMException;
import com.ghosttrio.judomanager.attendance.domain.Attendance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ghosttrio.judomanager.attendance.common.exception.ErrorCode.ATTENDANCE_NOT_FOUND;

/**
 * 출석 조회
 * 1. 오늘 강좌에 출석을 하지 않은 경우
 *  - 출석을 하지 못함
 *  - 미출석 이유 제출
 *  - 회원권 연장?
 * 2. 오늘 강좌에 출석을 한 경우
 *  -
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadAttendanceService {


    private final AttendanceJpaPort attendanceJpaPort;

    public Attendance loadAttendance(Long userId){
        return attendanceJpaPort.findAttendanceByUserId(userId)
                .orElseThrow(() -> new JMException(ATTENDANCE_NOT_FOUND));
    }

}
