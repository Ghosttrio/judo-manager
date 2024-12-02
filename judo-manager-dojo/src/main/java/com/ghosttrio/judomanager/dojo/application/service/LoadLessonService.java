package com.ghosttrio.judomanager.dojo.application.service;

import com.ghosttrio.judomanager.dojo.application.port.out.LessonJpaPort;
import com.ghosttrio.judomanager.dojo.common.exception.ErrorCode;
import com.ghosttrio.judomanager.dojo.common.exception.JMException;
import com.ghosttrio.judomanager.dojo.domain.Lesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadLessonService {

    private final LessonJpaPort lessonJpaPort;

    public Lesson findByUserId(Long userId) {
        return lessonJpaPort.findByUserId(userId)
                .orElseThrow(() -> new JMException(ErrorCode.LESSON_NOT_FOUND));
    }

}
