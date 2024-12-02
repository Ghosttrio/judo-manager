package com.ghosttrio.judomanager.dojo.application.port.in.impl;

import com.ghosttrio.judomanager.dojo.application.port.in.CreateLessonUseCase;
import com.ghosttrio.judomanager.dojo.application.service.CreateLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CreateLessonUseCaseImpl implements CreateLessonUseCase {

    private final CreateLessonService createLessonService;

    @Override
    public void execute(Long dojoId, String name, LocalDateTime startTime, LocalDateTime endTime) {
        createLessonService.create(dojoId, name, startTime, endTime);
    }
}
