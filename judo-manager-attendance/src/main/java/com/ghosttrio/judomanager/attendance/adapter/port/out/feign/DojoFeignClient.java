package com.ghosttrio.judomanager.attendance.adapter.port.out.feign;

import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.DojoCoordinateDto;
import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.Lesson;
import com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response.Pass;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "DojoFeignClient", url = "http://localhost:8000/api/v1/dojos"
)
public interface DojoFeignClient {

    @GetMapping("/test1")
    DojoCoordinateDto findDojoCoordinate();

    @GetMapping("/test2")
    Pass loadLessonByUserId(Long userId);

    @GetMapping("/test3")
    Lesson findByUserId(Long userId);
}
