package com.ghosttrio.judomanager.notice.application.port.in;

import com.ghosttrio.judomanager.notice.domain.Notice;

import java.util.List;

public interface LoadAllNoticeUseCase {
    List<Notice> execute();
}
