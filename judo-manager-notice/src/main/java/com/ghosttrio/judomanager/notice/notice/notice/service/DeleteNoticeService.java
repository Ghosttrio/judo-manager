//package com.ghosttrio.judomanager.notice.notice.notice.service;
//
//import com.ghosttrio.judomanager.notice.notice.notice.repository.NoticeRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class DeleteNoticeService {
//
//    private final NoticeRepository noticeRepository;
//    private final LoadNoticeService loadNoticeService;
//
//    @Transactional
//    public void deleteNotice(Long noticeId){
//        loadNoticeService.checkNoticeExist(noticeId);
//        noticeRepository.deleteById(noticeId);
//    }
//}
