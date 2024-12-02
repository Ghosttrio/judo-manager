package com.ghosttrio.judomanager.schedule.schedule.adapter.port.in;

import com.ghosttrio.judomanager.schedule.schedule.application.port.in.DeleteScheduleUseCase;
import com.ghosttrio.judomanager.schedule.schedule.application.service.DeleteScheduleService;
import com.ghosttrio.judomanager.schedule.schedule.common.exception.JMResponse;
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

    private final DeleteScheduleUseCase deleteScheduleUseCase;

    @DeleteMapping("/{scheduleId}")
    public JMResponse<Void> deleteSchedule(@PathVariable Long scheduleId){
        deleteScheduleUseCase.execute(scheduleId);
        return JMResponse.ok();
    }

}
