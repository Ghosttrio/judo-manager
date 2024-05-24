package com.judomanager.domain.dojo.repository.lesson;

import com.judomanager.domain.dojo.domain.Lesson;

import java.util.Optional;

public interface LessonQueryRepository {

    Optional<Lesson> findByUserId(Long userId);
}
