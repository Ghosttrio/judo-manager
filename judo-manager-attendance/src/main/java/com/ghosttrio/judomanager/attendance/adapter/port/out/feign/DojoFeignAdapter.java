package com.ghosttrio.judomanager.attendance.adapter.port.out.feign;

import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.DojoCoordinateDto;
import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.Lesson;
import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.Pass;
import com.ghosttrio.judomanager.attendance.application.port.out.DojoFeignPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DojoFeignAdapter implements DojoFeignPort {

    private final DojoFeignClient dojoFeignClient;

    @Override
    public DojoCoordinateDto findDojoCoordinate(Long dojoId) {
        return dojoFeignClient.findDojoCoordinate();
    }

    @Override
    public Pass loadLessonByUserId(Long userId) {
        return dojoFeignClient.loadLessonByUserId(userId);
    }

    @Override
    public Lesson findByUserId(Long userId) {
        return dojoFeignClient.findByUserId(userId);
    }

}
