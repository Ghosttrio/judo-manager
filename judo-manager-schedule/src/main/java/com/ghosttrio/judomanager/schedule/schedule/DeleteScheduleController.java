package com.ghosttrio.judomanager.schedule.schedule;

import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.schedule.service.DeleteScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedules")
@Tag(name = "[Schedule API]")
public class DeleteScheduleController {

    private final DeleteScheduleService deleteScheduleService;

    @DeleteMapping("/{scheduleId}")
    public JMResponse<Void> deleteSchedule(@PathVariable Long scheduleId){
        deleteScheduleService.delete(scheduleId);
        return JMResponse.ok();
    }

}
