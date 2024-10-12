package com.ghosttrio.judomanager.dojo.dojo.service;

import com.ghosttrio.judomanager.dojo.dojo.domain.Lesson;
import com.judomanager.common.exception.ErrorCode;
import com.judomanager.common.exception.JMException;
import com.ghosttrio.judomanager.dojo.dojo.repository.lesson.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.judomanager.common.exception.ErrorCode.LESSON_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadLessonService {

    private final LessonRepository lessonRepository;

    public Lesson findByUserId(Long userId){
        return lessonRepository.findByUserId(userId)
                .orElseThrow(() -> new JMException(ErrorCode.LESSON_NOT_FOUND));
    }


}
