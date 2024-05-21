package com.judomanager.controller.user.attendance;

import com.judomanager.service.attendance.CreateAttendanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendance")
@Tag(name = "출석 수정 컨트롤러")
public class UpdateAttendanceController {

    private final CreateAttendanceService createAttendanceService;

//    @PatchMapping
//    public JMResponse<Void> updateApproval(@UserId Long userId,
//                                           @RequestParam Long dojoId){
//        createAttendanceService.updateApproval(userId, dojoId);
//        return JMResponse.ok();
//    }

}
