package com.ghosttrio.judomanager.notice.application.port.in.impl;

import com.ghosttrio.judomanager.notice.application.port.in.LoadNoticeByDojoUseCase;
import com.ghosttrio.judomanager.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LoadNoticeByDojoUseCaseImpl implements LoadNoticeByDojoUseCase {
    @Override
    public List<Notice> execute(Long dojoId) {
        return null;
    }
}
