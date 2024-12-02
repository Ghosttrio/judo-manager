package com.ghosttrio.judomanager.notice.application.port.out;

import com.ghosttrio.judomanager.notice.domain.Notice;

import java.util.List;
import java.util.Optional;

public interface NoticeJpaPort {
    void save(Notice notice);

    Optional<Notice> findById(Long noticeId);

    List<Notice> findAllNoticeByDojoId(Long dojoId);

    List<Notice> findAll();

    Optional<Notice> checkTitleDuplicate(Long dojoId, String title);

    void deleteById(Long noticeId);

    void update(Long noticeId, String title, String content);
}
