package com.ghosttrio.judomanager.attendance.application.service;

import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.DojoCoordinateDto;
import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.Lesson;
import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.Pass;
import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity.AttendanceEntity;
import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.repository.AttendanceRepository;
import com.ghosttrio.judomanager.attendance.application.port.out.AttendanceJpaPort;
import com.ghosttrio.judomanager.attendance.application.port.out.DojoFeignPort;
import com.ghosttrio.judomanager.attendance.common.exception.ErrorCode;
import com.ghosttrio.judomanager.attendance.common.exception.JMException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.ghosttrio.judomanager.attendance.common.exception.ErrorCode.INVALID_ATTENDANCE_LOCATION;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateAttendanceService {

    private final DojoFeignPort dojoFeignPort;
    private final AttendanceJpaPort attendanceJpaPort;

    /** 등록한 회원권이 있는지, 레슨 시간에 맞는지, 위치가 맞는지 검증 */
    @Transactional
    public void create(Long userId, Long dojoId, Double latitude, Double longitude){
        validatePassExpired(userId);
        validateLessonTime(userId);
        validateLocation(dojoId, latitude, longitude);
        AttendanceEntity attendanceEntity = AttendanceEntity.create(userId, dojoId, LocalDateTime.now());
        attendanceJpaPort.save(attendanceEntity);
    }

    // todo 출석 시간 조건 추가
    private void validateLocation(Long dojoId, Double latitude, Double longitude){
        DojoCoordinateDto dojoCoordinate = dojoFeignPort.findDojoCoordinate(dojoId);
        Double result = attendanceJpaPort.checkLocation(dojoCoordinate.getLatitude(), dojoCoordinate.getLongitude(), latitude, longitude);
        if(result >= dojoCoordinate.getRadius()){
            throw new JMException(INVALID_ATTENDANCE_LOCATION);
        }
    }

    private void validatePassExpired(Long userId){
        LocalDateTime now = LocalDateTime.now();
        Pass pass = dojoFeignPort.loadLessonByUserId(userId);
        boolean result = pass.getExpireTime().isBefore(now);
        if(result){
            throw new JMException(ErrorCode.PASS_EXPIRED);
        }
    }

    private void validateLessonTime(Long userId){
        LocalDateTime now = LocalDateTime.now();
        Lesson lesson = dojoFeignPort.findByUserId(userId);
        if(lesson.getStartTime().isBefore(now) && lesson.getEndTime().isAfter(now)){
            throw new JMException(ErrorCode.INVALID_ATTENDANCE_TIME);
        }
    }
}
