package com.ghosttrio.judomanager.notice.application.service;

import com.ghosttrio.judomanager.notice.application.port.out.NoticeJpaPort;
import com.ghosttrio.judomanager.notice.common.exception.ErrorCode;
import com.ghosttrio.judomanager.notice.common.exception.JMException;
import com.ghosttrio.judomanager.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadNoticeService {

    private final NoticeJpaPort noticeJpaPort;

    public List<Notice> findAllNotice(){
        return noticeJpaPort.findAll();
    }

    public List<Notice> findAllNoticeByDojoId(Long dojoId){
        return noticeJpaPort.findAllNoticeByDojoId(dojoId);
    }

    public Notice checkNoticeExist(Long noticeId){
        return noticeJpaPort.findById(noticeId)
                .orElseThrow(() -> new JMException(ErrorCode.NOTICE_NOT_FOUND));
    }
}
