package com.ghosttrio.judomanager.dojo.adapter.port.in;

import com.ghosttrio.judomanager.dojo.adapter.port.in.request.CreateLessonRequest;
import com.ghosttrio.judomanager.dojo.application.port.in.CreateLessonUseCase;
import com.ghosttrio.judomanager.dojo.common.exception.JMResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dojos/lessons")
@Tag(name = "[Dojo API]")
public class CreateLessonController {

    private final CreateLessonUseCase createLessonUseCase;

    @PostMapping
    public JMResponse<Void> createLesson(@RequestBody CreateLessonRequest request){
        createLessonUseCase.execute(request.dojoId(), request.name(), request.startTime(), request.endTime());
        return JMResponse.ok();
    }

}
