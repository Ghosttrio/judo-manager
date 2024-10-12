package com.ghosttrio.judomanager.attendance.attendance;

import com.judomanager.domain.attendance.service.CreateAttendanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendance")
@Tag(name = "[Attendance API]")
public class UpdateAttendanceController {
}
