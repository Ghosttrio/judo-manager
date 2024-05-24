package com.judomanager.api.presentation.schedule;

import com.judomanager.api.presentation.schedule.request.UpdateScheduleRequest;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.schedule.service.UpdateScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedules")
@Tag(name = "[Schedule API]")
public class UpdateScheduleController {

    private final UpdateScheduleService updateScheduleService;

    @PatchMapping("/{scheduleId}")
    public JMResponse<Void> deleteSchedule(@PathVariable Long scheduleId,
                                           @RequestBody UpdateScheduleRequest request){
        updateScheduleService.update(scheduleId, request.title(), request.content());
        return JMResponse.ok();
    }
}
