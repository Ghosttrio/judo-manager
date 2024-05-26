package com.judomanager.domain.notice;

import com.judomanager.domain.config.MockitoSupport;
import com.judomanager.domain.notice.domain.Notice;
import com.judomanager.domain.notice.service.LoadNoticeService;
import com.judomanager.domain.notice.service.UpdateNoticeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;

class UpdateNoticeServiceTest extends MockitoSupport {

    @InjectMocks
    private UpdateNoticeService updateNoticeService;
    @Mock
    private LoadNoticeService loadNoticeService;

    @Test
    void updateNotice() {
        Notice notice = monkey.giveMeOne(Notice.class);
        String newTitle = monkey.giveMeOne(String.class);

        given(loadNoticeService.checkNoticeExist(notice.getId())).willReturn(notice);

        Assertions.assertThatNoException().isThrownBy(
                () -> updateNoticeService.updateNotice(notice.getId(), newTitle, notice.getContent())
        );
    }

}