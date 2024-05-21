package com.judomanager.api.controller.user.attendance;

import com.judomanager.api.security.UserId;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendance")
@Tag(name = "출석 조회 컨트롤러")
public class LoadAttendanceController {

    @GetMapping
    public void loadUserAttendance(@UserId Long userId){
        // 유저의 출석 여부 확인
    }
}
