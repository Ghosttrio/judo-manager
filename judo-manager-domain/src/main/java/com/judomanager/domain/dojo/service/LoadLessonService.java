package com.judomanager.domain.dojo.service;

import ch.qos.logback.core.spi.ErrorCodes;
import com.judomanager.common.exception.ErrorCode;
import com.judomanager.common.exception.JMException;
import com.judomanager.domain.dojo.domain.Lesson;
import com.judomanager.domain.dojo.repository.lesson.LessonRepository;
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
                .orElseThrow(() -> new JMException(LESSON_NOT_FOUND));
    }


}
