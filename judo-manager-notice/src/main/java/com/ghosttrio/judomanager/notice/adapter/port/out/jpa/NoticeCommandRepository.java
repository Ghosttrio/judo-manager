package com.ghosttrio.judomanager.notice.adapter.port.out.jpa;

public interface NoticeCommandRepository {
    void update(Long noticeId, String title, String content);
}
