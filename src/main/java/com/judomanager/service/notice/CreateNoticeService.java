package com.judomanager.service.notice;

import com.judomanager.common.exception.JMException;
import com.judomanager.domain.notice.Notice;
import com.judomanager.repository.notice.NoticeRepository;
import com.judomanager.service.dojo.LoadDojoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.judomanager.common.exception.ErrorCode.NOTICE_TITLE_DUPLICATE;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CreateNoticeService {

    private final NoticeRepository noticeRepository;
    private final LoadDojoService loadDojoService;

    @Transactional
    public void saveNotice(Long dojoId, String title, String content){

        loadDojoService.checkDojoExist(dojoId);
        checkTitleDuplicate(dojoId, title);

        Notice notice = Notice.create(dojoId, title, content);
        noticeRepository.save(notice);
    }


    public void checkTitleDuplicate(Long dojoId, String title){
        noticeRepository.checkTitleDuplicate(dojoId, title).ifPresent(t -> {
            throw new JMException(NOTICE_TITLE_DUPLICATE);
        });
    }
}
