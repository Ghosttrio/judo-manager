package com.ghosttrio.judomanager.notice.application.service;

import com.ghosttrio.judomanager.notice.application.port.out.NoticeJpaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeleteNoticeService {

    private final LoadNoticeService loadNoticeService;
    private final NoticeJpaPort noticeJpaPort;

    @Transactional
    public void deleteNotice(Long noticeId){
        loadNoticeService.checkNoticeExist(noticeId);
        noticeJpaPort.deleteById(noticeId);
    }
}
