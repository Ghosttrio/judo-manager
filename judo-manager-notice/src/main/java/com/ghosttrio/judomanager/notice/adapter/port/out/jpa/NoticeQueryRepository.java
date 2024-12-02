package com.ghosttrio.judomanager.notice.adapter.port.out.jpa;


import com.ghosttrio.judomanager.notice.domain.Notice;

import java.util.List;
import java.util.Optional;

public interface NoticeQueryRepository {

    List<Notice> findAllNoticeByDojoId(Long dojoId);

    Optional<Notice> checkTitleDuplicate(Long dojoId, String title);
}
