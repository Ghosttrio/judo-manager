package com.ghosttrio.judomanager.notice.application.port.in.impl;

import com.ghosttrio.judomanager.notice.application.port.in.DeleteNoticeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteNoticeUseCaseImpl implements DeleteNoticeUseCase {
    @Override
    public void execute(Long noticeId) {

    }
}
