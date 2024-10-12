package com.ghosttrio.judomanager.dojo.dojo.repository.lesson;

import com.ghosttrio.judomanager.dojo.dojo.domain.Lesson;

import java.util.Optional;

public interface LessonQueryRepository {

    Optional<Lesson> findByUserId(Long userId);
}
