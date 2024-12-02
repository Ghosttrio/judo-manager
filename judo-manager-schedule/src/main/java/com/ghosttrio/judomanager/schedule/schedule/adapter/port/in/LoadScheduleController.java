package com.ghosttrio.judomanager.schedule.schedule.adapter.port.in;

import com.ghosttrio.judomanager.schedule.schedule.application.port.in.LoadDojoAllScheduleUseCase;
import com.ghosttrio.judomanager.schedule.schedule.application.port.in.LoadDojoWeekScheduleUseCase;
import com.ghosttrio.judomanager.schedule.schedule.application.port.in.LoadScheduleUseCase;
import com.ghosttrio.judomanager.schedule.schedule.common.exception.JMResponse;
import com.ghosttrio.judomanager.schedule.schedule.domain.Schedule;
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

    private final LoadDojoAllScheduleUseCase loadDojoAllScheduleUseCase;
    private final LoadDojoWeekScheduleUseCase loadDojoWeekScheduleUseCase;
    private final LoadScheduleUseCase loadScheduleUseCase;

    @GetMapping("/{scheduleId}")
    public JMResponse<Schedule> loadSchedule(@PathVariable Long scheduleId){
        Schedule result = loadScheduleUseCase.execute(scheduleId);
        return JMResponse.ok(result);
    }

    @Operation(summary = "해당 유도장의 전체 일정을 가져옵니다.")
    @GetMapping("/dojos/{dojoId}")
    public JMResponse<List<Schedule>> loadAllDojoSchedule(@PathVariable Long dojoId){
        List<Schedule> result = loadDojoAllScheduleUseCase.execute(dojoId);
        return JMResponse.ok(result);
    }

    @Operation(summary = "해당 유도장의 주간 일정을 가져옵니다.")
    @GetMapping("/dojos/{dojoId}/week")
    public JMResponse<List<Schedule>> loadAllDojoScheduleWeek(@PathVariable Long dojoId){
        List<Schedule> result = loadDojoWeekScheduleUseCase.execute(dojoId);
        return JMResponse.ok(result);
    }

}
