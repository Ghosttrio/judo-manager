//package com.ghosttrio.judomanager.notice.notice.notice.service;
//
//import com.judomanager.common.exception.JMException;
//import com.judomanager.domain.dojo.service.LoadDojoService;
//import com.ghosttrio.judomanager.notice.notice.notice.domain.Notice;
//import com.ghosttrio.judomanager.notice.notice.notice.repository.NoticeRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import static com.judomanager.common.exception.ErrorCode.NOTICE_TITLE_DUPLICATE;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class CreateNoticeService {
//
//    private final NoticeRepository noticeRepository;
//    private final LoadDojoService loadDojoService;
//
//    @Transactional
//    public void saveNotice(Long dojoId, String title, String content){
//
//        loadDojoService.checkDojoExist(dojoId);
//        checkTitleDuplicate(dojoId, title);
//
//        Notice notice = Notice.create(dojoId, title, content);
//        noticeRepository.save(notice);
//    }
//
//
//    public void checkTitleDuplicate(Long dojoId, String title){
//        noticeRepository.checkTitleDuplicate(dojoId, title).ifPresent(t -> {
//            throw new JMException(ErrorCode.NOTICE_TITLE_DUPLICATE);
//        });
//    }
//}
