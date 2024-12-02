package com.ghosttrio.judomanager.notice.application.service;

import com.ghosttrio.judomanager.notice.application.port.out.NoticeJpaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UpdateNoticeService {

    private final NoticeJpaPort noticeJpaPort;

    @Transactional
    public void updateNotice(Long noticeId, String title, String content){
        noticeJpaPort.update(noticeId, title, content);
    }
}
