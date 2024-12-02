package com.ghosttrio.judomanager.schedule.schedule.adapter.port.in;

import com.ghosttrio.judomanager.schedule.schedule.adapter.port.in.request.UpdateScheduleRequest;
import com.ghosttrio.judomanager.schedule.schedule.application.service.UpdateScheduleService;
import com.ghosttrio.judomanager.schedule.schedule.common.exception.JMResponse;
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
