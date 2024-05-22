package com.judomanager.domain.notice.service;

import com.judomanager.domain.notice.domain.Notice;
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
