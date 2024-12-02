package com.ghosttrio.judomanager.dojo.application.service;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.LessonEntity;
import com.ghosttrio.judomanager.dojo.application.port.out.LessonJpaPort;
import com.ghosttrio.judomanager.dojo.domain.Lesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateLessonService {

    private final LessonJpaPort lessonJpaPort;

    @Transactional
    public void create(Long dojoId, String name, LocalDateTime startTime, LocalDateTime endTime){
        Lesson lesson = Lesson.create(dojoId, name, startTime, endTime);
        lessonJpaPort.save(lesson);
    }

}
