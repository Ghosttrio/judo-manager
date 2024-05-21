package com.judomanager.controller.user.schedule;

import com.judomanager.common.JMResponse;
import com.judomanager.dto.schedule.CreateScheduleRequest;
import com.judomanager.service.schedule.CreateScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedules")
public class CreateScheduleController {

    private final CreateScheduleService createScheduleService;

    @PostMapping
    public JMResponse<Void> createSchedule(@RequestBody CreateScheduleRequest request){
        createScheduleService.create(request.dojoId(), request.title(), request.content());
        return JMResponse.ok();
    }
}
