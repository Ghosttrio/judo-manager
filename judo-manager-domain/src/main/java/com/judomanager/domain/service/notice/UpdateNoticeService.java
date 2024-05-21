package com.judomanager.domain.service.notice;

import com.judomanager.domain.domain.notice.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UpdateNoticeService {

    private final LoadNoticeService loadNoticeService;

    @Transactional
    public void updateNotice(Long noticeId, String title, String content){
        Notice notice = loadNoticeService.checkNoticeExist(noticeId);
        notice.update(title, content);
    }
}
