package com.judomanager.api.controller.user.schedule;

import com.judomanager.common.common.JMResponse;
import com.judomanager.domain.service.schedule.DeleteScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedules")
public class DeleteScheduleController {

    private final DeleteScheduleService deleteScheduleService;

    @DeleteMapping("/{scheduleId}")
    public JMResponse<Void> deleteSchedule(@PathVariable Long scheduleId){
        deleteScheduleService.delete(scheduleId);
        return JMResponse.ok();
    }

}
