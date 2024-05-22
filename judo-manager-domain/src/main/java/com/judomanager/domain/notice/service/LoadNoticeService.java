package com.judomanager.domain.notice.service;

import com.judomanager.common.exception.JMException;
import com.judomanager.domain.notice.domain.Notice;
import com.judomanager.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.judomanager.common.exception.ErrorCode.NOTICE_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadNoticeService {

    private final NoticeRepository noticeRepository;

    public List<Notice> findAllNotice(){
        return noticeRepository.findAll();
    }

    public List<Notice> findAllNoticeByDojoId(Long dojoId){
        return noticeRepository.findAllNoticeByDojoId(dojoId);
    }

    public Notice checkNoticeExist(Long noticeId){
        return noticeRepository.findById(noticeId)
                .orElseThrow(() -> new JMException(NOTICE_NOT_FOUND));
    }
}
