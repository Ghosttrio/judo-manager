package com.judomanager.api.controller.user.schedule;

import com.judomanager.common.common.JMResponse;
import com.judomanager.domain.domain.schedule.Schedule;
import com.judomanager.domain.service.schedule.LoadScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedules")
public class LoadScheduleController {

    private final LoadScheduleService loadScheduleService;

    @GetMapping("/{dojoId}")
    public JMResponse<List<Schedule>> loadAllDojoSchedule(@PathVariable Long dojoId){
        List<Schedule> result = loadScheduleService.findAllByDojoId(dojoId);
        return JMResponse.ok(result);
    }

    @GetMapping("/{scheduleId}")
    public JMResponse<Schedule> loadSchedule(@PathVariable Long scheduleId){
        Schedule result = loadScheduleService.findSchedule(scheduleId);
        return JMResponse.ok(result);
    }
}
