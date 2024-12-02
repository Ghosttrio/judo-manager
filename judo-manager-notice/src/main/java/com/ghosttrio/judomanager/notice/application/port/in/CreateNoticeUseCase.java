package com.ghosttrio.judomanager.notice.application.port.in;

public interface CreateNoticeUseCase {
    void execute(Long dojoId, String title, String content);
}
