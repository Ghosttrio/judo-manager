package com.ghosttrio.judomanager.dojo.dojo.repository.lesson;

import com.ghosttrio.judomanager.dojo.dojo.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long>, LessonQueryRepository {
}
