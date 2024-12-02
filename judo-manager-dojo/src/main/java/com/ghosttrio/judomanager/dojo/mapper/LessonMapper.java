package com.ghosttrio.judomanager.dojo.mapper;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.LessonEntity;
import com.ghosttrio.judomanager.dojo.domain.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper {
    public LessonEntity toEntity(Lesson lesson) {
        return LessonEntity.create(
                lesson.getDojoId(),
                lesson.getName(),
                lesson.getStartTime(),
                lesson.getEndTime()
        );
    }

    public Lesson toDomain(LessonEntity lesson) {
        return Lesson.create(
                lesson.getDojoId(),
                lesson.getName(),
                lesson.getStartTime(),
                lesson.getEndTime()
        );
    }
}
