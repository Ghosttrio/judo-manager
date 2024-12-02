package com.ghosttrio.judomanager.notice.adapter.port.out.jpa;

import com.ghosttrio.judomanager.notice.application.port.out.NoticeJpaPort;
import com.ghosttrio.judomanager.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NoticeJpaAdapter implements NoticeJpaPort {

    private final NoticeRepository noticeRepository;

    @Override
    public void save(Notice notice) {
        noticeRepository.save(notice);
    }

    @Override
    public Optional<Notice> findById(Long noticeId) {
        return noticeRepository.findById(noticeId);
    }

    @Override
    public List<Notice> findAllNoticeByDojoId(Long dojoId) {
        return noticeRepository.findAllNoticeByDojoId(dojoId);
    }

    @Override
    public List<Notice> findAll() {
        return noticeRepository.findAll();
    }

    @Override
    public Optional<Notice> checkTitleDuplicate(Long dojoId, String title) {
        return noticeRepository.checkTitleDuplicate(dojoId, title);
    }

    @Override
    public void deleteById(Long noticeId) {
        noticeRepository.deleteById(noticeId);
    }

    @Override
    public void update(Long noticeId, String title, String content) {
        noticeRepository.update(noticeId, title, content);
    }
}
