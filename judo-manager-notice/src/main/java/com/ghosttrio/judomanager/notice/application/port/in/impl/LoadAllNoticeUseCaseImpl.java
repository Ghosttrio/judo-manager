package com.ghosttrio.judomanager.notice.application.port.in.impl;

import com.ghosttrio.judomanager.notice.application.port.in.LoadAllNoticeUseCase;
import com.ghosttrio.judomanager.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class LoadAllNoticeUseCaseImpl implements LoadAllNoticeUseCase {
    @Override
    public List<Notice> execute() {
        return null;
    }
}
