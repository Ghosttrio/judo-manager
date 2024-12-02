package com.ghosttrio.judomanager.notice.application.port.in;

public interface UpdateNoticeUseCase {
    void execute(Long noticeId, String title, String content);
}
