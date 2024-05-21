//package com.judomanager.api.service.notice;
//
//import com.judomanager.config.MockitoSupport;
//import com.judomanager.domain.notice.Notice;
//import com.judomanager.domain.service.notice.CreateNoticeService;
//import com.judomanager.repository.notice.NoticeRepository;
//import com.judomanager.service.dojo.LoadDojoService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.*;
//import static org.mockito.Mockito.times;
//
//
//class CreateNoticeServiceTest extends MockitoSupport {
//
//    @InjectMocks
//    protected CreateNoticeService createNoticeService;
//    @Mock
//    protected LoadDojoService loadDojoService;
//    @Mock
//    protected NoticeRepository noticeRepository;
//
//    @Test
//    void saveNotice() {
//        //given
//        Notice notice = monkey.giveMeOne(Notice.class);
//        willDoNothing().given(loadDojoService).checkDojoExist(notice.getDojoId());
//        given(noticeRepository.checkTitleDuplicate(notice.getDojoId(), notice.getTitle())).willReturn(Optional.empty());
//
//        //when
//        createNoticeService.saveNotice(notice.getDojoId(), notice.getTitle(), notice.getContent());
//
//        //then
//        then(noticeRepository).should(times(1)).save(any());
//    }
//}