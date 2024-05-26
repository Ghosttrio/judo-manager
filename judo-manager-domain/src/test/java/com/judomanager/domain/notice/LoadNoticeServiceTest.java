package com.judomanager.domain.notice;

import com.judomanager.domain.config.MockitoSupport;
import com.judomanager.domain.notice.domain.Notice;
import com.judomanager.domain.notice.repository.NoticeRepository;
import com.judomanager.domain.notice.service.LoadNoticeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

class LoadNoticeServiceTest extends MockitoSupport {

    @InjectMocks
    protected LoadNoticeService loadNoticeService;
    @Mock
    protected NoticeRepository noticeRepository;

    @Test
    void findAllNotice() {
    }

    @Test
    @DisplayName("도장별 공지사항 목록 조회")
    void findAllNoticeByDojoId() {
        // given
        Long dojoId = monkey.giveMeOne(Long.class);
        List<Notice> notices = monkey.giveMe(Notice.class, 3);

        given(noticeRepository.findAllNoticeByDojoId(dojoId)).willReturn(notices);

        // when
        List<Notice> result = loadNoticeService.findAllNoticeByDojoId(dojoId);

        // then
        assertThat(notices).isEqualTo(result);
    }

    @Test
    @DisplayName("공지사항 존재 확인 성공")
    void checkNoticeExist() {
        // given
        Long noticeId = monkey.giveMeOne(Long.class);
        Notice notice = monkey.giveMeOne(Notice.class);

        given(noticeRepository.findById(noticeId)).willReturn(Optional.ofNullable(notice));

        // when
        Notice result = loadNoticeService.checkNoticeExist(noticeId);

        // then
        assertThat(result).isEqualTo(notice);
    }

    @Test
    @DisplayName("공지사항 존재 확인 실패")
    void checkNoticeExistFail() {
        // given
        Long noticeId = monkey.giveMeOne(Long.class);

        given(noticeRepository.findById(noticeId)).willReturn(Optional.empty());

        // when, then
        Assertions.assertThatException()
                .isThrownBy(() -> loadNoticeService.checkNoticeExist(noticeId));
    }
}