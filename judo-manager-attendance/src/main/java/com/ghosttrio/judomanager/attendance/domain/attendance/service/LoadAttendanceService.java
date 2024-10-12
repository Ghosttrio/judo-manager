package com.ghosttrio.judomanager.attendance.domain.attendance.service;

import com.judomanager.common.exception.JMException;
import com.judomanager.domain.attendance.domain.Attendance;
import com.judomanager.domain.attendance.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.judomanager.common.exception.ErrorCode.ATTENDANCE_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadAttendanceService {


    private final AttendanceRepository attendanceRepository;

    /**
     * 출석 조회
     * 1. 오늘 강좌에 출석을 하지 않은 경우
     *  - 출석을 하지 못함
     *  - 미출석 이유 제출
     *  - 회원권 연장?
     * 2. 오늘 강좌에 출석을 한 경우
     *  -
     */
    public Attendance loadAttendance(Long userId){
        return attendanceRepository.findAttendanceByUserId(userId)
                .orElseThrow(() -> new JMException(ATTENDANCE_NOT_FOUND));
    }

}
