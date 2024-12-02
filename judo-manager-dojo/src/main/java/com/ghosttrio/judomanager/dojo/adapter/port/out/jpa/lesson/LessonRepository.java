package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.lesson;


import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<LessonEntity, Long>, LessonQueryRepository {
}
