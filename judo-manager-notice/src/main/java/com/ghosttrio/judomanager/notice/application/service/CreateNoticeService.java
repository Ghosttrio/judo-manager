package com.ghosttrio.judomanager.notice.application.service;

import com.ghosttrio.judomanager.notice.application.port.out.DojoFeignPort;
import com.ghosttrio.judomanager.notice.application.port.out.NoticeJpaPort;
import com.ghosttrio.judomanager.notice.common.exception.ErrorCode;
import com.ghosttrio.judomanager.notice.common.exception.JMException;
import com.ghosttrio.judomanager.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CreateNoticeService {

    private final DojoFeignPort dojoFeignPort;
    private final NoticeJpaPort noticeJpaPort;

    @Transactional
    public void saveNotice(Long dojoId, String title, String content){

        dojoFeignPort.checkDojoExist(dojoId);
        checkTitleDuplicate(dojoId, title);

        Notice notice = Notice.create(dojoId, title, content);
        noticeJpaPort.save(notice);
    }


    public void checkTitleDuplicate(Long dojoId, String title){
        noticeJpaPort.checkTitleDuplicate(dojoId, title).ifPresent(t -> {
            throw new JMException(ErrorCode.NOTICE_TITLE_DUPLICATE);
        });
    }
}
