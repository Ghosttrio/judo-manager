package com.judomanager.domain.notice;

import com.judomanager.domain.config.MockitoSupport;
import com.judomanager.domain.notice.domain.Notice;
import com.judomanager.domain.notice.repository.NoticeRepository;
import com.judomanager.domain.notice.service.DeleteNoticeService;
import com.judomanager.domain.notice.service.LoadNoticeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

class DeleteNoticeServiceTest extends MockitoSupport {

    @InjectMocks
    private DeleteNoticeService deleteNoticeService;
    @Mock
    private LoadNoticeService loadNoticeService;
    @Mock
    private NoticeRepository noticeRepository;

    @Test
    void deleteNotice() {
        //given
        Notice notice = monkey.giveMeOne(Notice.class);

        given(loadNoticeService.checkNoticeExist(notice.getId())).willReturn(notice);

        //when
        deleteNoticeService.deleteNotice(notice.getId());

        //then
        then(noticeRepository).should(times(1)).deleteById(notice.getId());
    }

}