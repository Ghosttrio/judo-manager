package com.judomanager.api.presentation.schedule;

import com.judomanager.api.presentation.schedule.dto.CreateScheduleRequest;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.schedule.service.CreateScheduleService;
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

    private final CreateScheduleService createScheduleService;

    @PostMapping
    public JMResponse<Void> createSchedule(@RequestBody CreateScheduleRequest request){
        createScheduleService.create(request.dojoId(), request.title(), request.content());
        return JMResponse.ok();
    }
}
