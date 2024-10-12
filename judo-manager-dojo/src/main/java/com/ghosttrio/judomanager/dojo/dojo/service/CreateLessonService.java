package com.ghosttrio.judomanager.dojo.dojo.service;

import com.ghosttrio.judomanager.dojo.dojo.domain.Lesson;
import com.ghosttrio.judomanager.dojo.dojo.repository.lesson.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateLessonService {

    private final LessonRepository lessonRepository;

    @Transactional
    public void create(Long dojoId, String name, LocalDateTime startTime, LocalDateTime endTime){
        Lesson lesson = Lesson.create(dojoId, name, startTime, endTime);
        lessonRepository.save(lesson);
    }

}
