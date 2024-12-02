package com.ghosttrio.judomanager.attendance.application.port.out;

import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.DojoCoordinateDto;
import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.Lesson;
import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.Pass;

public interface DojoFeignPort {
    DojoCoordinateDto findDojoCoordinate(Long dojoId);

    Pass loadLessonByUserId(Long userId);

    Lesson findByUserId(Long userId);
}
