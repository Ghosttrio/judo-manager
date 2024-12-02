package com.ghosttrio.judomanager.notice.application.port.in.impl;

import com.ghosttrio.judomanager.notice.application.port.in.UpdateNoticeUseCase;
import com.ghosttrio.judomanager.notice.application.service.UpdateNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateNoticeUseCaseImpl implements UpdateNoticeUseCase {

    private final UpdateNoticeService updateNoticeService;

    @Override
    public void execute(Long noticeId, String title, String content) {
        updateNoticeService.updateNotice(noticeId, title, content);
    }
}
