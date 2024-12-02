package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.lesson;


import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.LessonEntity;

import java.util.Optional;

public interface LessonQueryRepository {

    Optional<LessonEntity> findByUserId(Long userId);
}
