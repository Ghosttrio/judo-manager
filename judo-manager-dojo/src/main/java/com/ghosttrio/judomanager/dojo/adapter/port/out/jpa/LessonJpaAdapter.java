package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.LessonEntity;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.lesson.LessonRepository;
import com.ghosttrio.judomanager.dojo.application.port.out.LessonJpaPort;
import com.ghosttrio.judomanager.dojo.domain.Lesson;
import com.ghosttrio.judomanager.dojo.mapper.LessonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LessonJpaAdapter implements LessonJpaPort {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public void save(Lesson lesson) {
        LessonEntity entity = lessonMapper.toEntity(lesson);
        lessonRepository.save(entity);
    }

    @Override
    public Optional<Lesson> findByUserId(Long userId) {
        Optional<LessonEntity> lessonEntity = lessonRepository.findByUserId(userId);
        return lessonEntity.map(lessonMapper::toDomain);
    }
}
