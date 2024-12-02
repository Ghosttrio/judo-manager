package com.ghosttrio.judomanager.schedule.schedule.adapter.port.in;

import com.ghosttrio.judomanager.schedule.schedule.adapter.port.in.request.CreateScheduleRequest;
import com.ghosttrio.judomanager.schedule.schedule.application.port.in.CreateScheduleUseCase;
import com.ghosttrio.judomanager.schedule.schedule.application.service.CreateScheduleService;
import com.ghosttrio.judomanager.schedule.schedule.common.exception.JMResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedules")
@Tag(name = "[Schedule API]")
public class CreateScheduleController {

    private final CreateScheduleUseCase createScheduleUseCase;

    @PostMapping
    public JMResponse<Void> createSchedule(@RequestBody CreateScheduleRequest request){
        createScheduleUseCase.execute(
                request.dojoId(),
                request.title(),
                request.content(),
                request.startTime());
        return JMResponse.ok();
    }
}
