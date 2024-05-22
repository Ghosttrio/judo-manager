package com.judomanager.domain.attendance.service;

import com.judomanager.domain.attendance.domain.Attendance;
import com.judomanager.domain.attendance.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateAttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Transactional
    public void create(Long userId, Long dojoId, double latitude, double longitude){
        validateLocation(latitude, longitude);
        Attendance attendance = Attendance.create(userId, dojoId);
        attendanceRepository.save(attendance);
    }

    private void validateLocation(double latitude, double longitude){
        // todo 이미 출석을 했으면 출석 x
        // todo 하버사인 공식을 이용하여 도장이 등록한 위치와 기준 거리보다 길면 exception
        // todo 출석 시간 조건 추가
    }
}
