package com.judomanager.domain.attendance.service;

import com.judomanager.common.exception.ErrorCode;
import com.judomanager.common.exception.JMException;
import com.judomanager.domain.attendance.domain.Attendance;
import com.judomanager.domain.attendance.repository.AttendanceRepository;
import com.judomanager.domain.dojo.domain.Lesson;
import com.judomanager.domain.dojo.domain.Pass;
import com.judomanager.domain.dojo.repository.dojo.projections.DojoCoordinateDto;
import com.judomanager.domain.dojo.service.LoadDojoService;
import com.judomanager.domain.dojo.service.LoadLessonService;
import com.judomanager.domain.dojo.service.LoadPassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.judomanager.common.exception.ErrorCode.INVALID_ATTENDANCE_LOCATION;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateAttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final LoadDojoService loadDojoService;
    private final LoadPassService loadPassService;
    private final LoadLessonService loadLessonService;

    /** 등록한 회원권이 있는지, 레슨 시간에 맞는지, 위치가 맞는지 검증 */
    @Transactional
    public void create(Long userId, Long dojoId, Double latitude, Double longitude){
        validatePassExpired(userId);
        validateLessonTime(userId);
        validateLocation(dojoId, latitude, longitude);
        Attendance attendance = Attendance.create(userId, dojoId, LocalDateTime.now());
        attendanceRepository.save(attendance);
    }

    // todo 출석 시간 조건 추가
    private void validateLocation(Long dojoId, Double latitude, Double longitude){
        DojoCoordinateDto dojoCoordinate = loadDojoService.findDojoCoordinate(dojoId);
        Double result = attendanceRepository.checkLocation(dojoCoordinate.latitude(), dojoCoordinate.longitude(), latitude, longitude);
        if(result >= dojoCoordinate.radius()){
            throw new JMException(INVALID_ATTENDANCE_LOCATION);
        }
    }

    private void validatePassExpired(Long userId){
        LocalDateTime now = LocalDateTime.now();
        Pass pass = loadPassService.loadLessonByUserId(userId);
        boolean result = pass.getExpireTime().isBefore(now);
        if(result){
            throw new JMException(ErrorCode.PASS_EXPIRED);
        }
    }

    private void validateLessonTime(Long userId){
        LocalDateTime now = LocalDateTime.now();
        Lesson lesson = loadLessonService.findByUserId(userId);
        if(lesson.getStartTime().isBefore(now) && lesson.getEndTime().isAfter(now)){
            throw new JMException(ErrorCode.INVALID_ATTENDANCE_TIME);
        }
    }
}
