package com.ghosttrio.judomanager.notice.application.port.in.impl;

import com.ghosttrio.judomanager.notice.application.port.in.CreateNoticeUseCase;
import com.ghosttrio.judomanager.notice.application.service.CreateNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateNoticeUseCaseImpl implements CreateNoticeUseCase {

    private final CreateNoticeService createNoticeService;

    @Override
    public void execute(Long dojoId, String title, String content) {
        createNoticeService.saveNotice(dojoId, title, content);
    }
}
