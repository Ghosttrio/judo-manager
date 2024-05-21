package com.judomanager.domain.repository.notice;


import com.judomanager.domain.domain.notice.Notice;

import java.util.List;
import java.util.Optional;

public interface NoticeQueryRepository {

    List<Notice> findAllNoticeByDojoId(Long dojoId);

    Optional<Notice> checkTitleDuplicate(Long dojoId, String title);
}
