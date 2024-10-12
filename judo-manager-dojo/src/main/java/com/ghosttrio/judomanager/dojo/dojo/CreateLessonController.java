package com.ghosttrio.judomanager.dojo.dojo;

import com.ghosttrio.judomanager.dojo.dojo.request.CreateLessonRequest;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.dojo.service.CreateLessonService;
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

    private final CreateLessonService createLessonService;

    @PostMapping
    public JMResponse<Void> createLesson(@RequestBody CreateLessonRequest request){
        createLessonService.create(request.dojoId(), request.name(), request.startTime(), request.endTime());
        return JMResponse.ok();
    }

}
