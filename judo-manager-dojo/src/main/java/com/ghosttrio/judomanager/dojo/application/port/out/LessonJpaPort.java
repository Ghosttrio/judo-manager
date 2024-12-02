package com.ghosttrio.judomanager.dojo.application.port.out;

import com.ghosttrio.judomanager.dojo.domain.Lesson;

import java.util.Optional;

public interface LessonJpaPort {
    void save(Lesson lesson);

    Optional<Lesson> findByUserId(Long userId);
}
