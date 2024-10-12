package com.ghosttrio.judomanager.schedule.schedule;

import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.schedule.domain.Schedule;
import com.judomanager.domain.schedule.service.LoadScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedules")
@Tag(name = "[Schedule API]")
public class LoadScheduleController {

    private final LoadScheduleService loadScheduleService;

    @Operation(summary = "해당 유도장의 전체 일정을 가져옵니다.")
    @GetMapping("/{dojoId}")
    public JMResponse<List<Schedule>> loadAllDojoSchedule(@PathVariable Long dojoId){
        List<Schedule> result = loadScheduleService.findAllByDojoId(dojoId);
        return JMResponse.ok(result);
    }

    @Operation(summary = "해당 유도장의 주간 일정을 가져옵니다.")
    @GetMapping("/{dojoId}/week")
    public JMResponse<List<Schedule>> loadAllDojoScheduleWeek(@PathVariable Long dojoId){
        List<Schedule> result = loadScheduleService.findAllByDojoIdWeek(dojoId);
        return JMResponse.ok(result);
    }

    @GetMapping("/{scheduleId}")
    public JMResponse<Schedule> loadSchedule(@PathVariable Long scheduleId){
        Schedule result = loadScheduleService.findSchedule(scheduleId);
        return JMResponse.ok(result);
    }
}
