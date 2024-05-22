package com.judomanager.api.presentation.schedule;

import com.judomanager.api.presentation.schedule.dto.UpdateScheduleRequest;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.schedule.service.UpdateScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedules")
public class UpdateScheduleController {

    private final UpdateScheduleService updateScheduleService;

    @PatchMapping("/{scheduleId}")
    public JMResponse<Void> deleteSchedule(@PathVariable Long scheduleId,
                                           @RequestBody UpdateScheduleRequest request){
        updateScheduleService.update(scheduleId, request.title(), request.content());
        return JMResponse.ok();
    }
}
