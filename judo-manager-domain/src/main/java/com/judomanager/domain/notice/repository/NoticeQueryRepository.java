package com.judomanager.domain.notice.repository;



import com.judomanager.domain.notice.domain.Notice;

import java.util.List;
import java.util.Optional;

public interface NoticeQueryRepository {

    List<Notice> findAllNoticeByDojoId(Long dojoId);

    Optional<Notice> checkTitleDuplicate(Long dojoId, String title);
}
