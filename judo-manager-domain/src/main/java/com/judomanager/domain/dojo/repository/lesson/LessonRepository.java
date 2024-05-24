package com.judomanager.domain.dojo.repository.lesson;

import com.judomanager.domain.dojo.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long>, LessonQueryRepository {
}
