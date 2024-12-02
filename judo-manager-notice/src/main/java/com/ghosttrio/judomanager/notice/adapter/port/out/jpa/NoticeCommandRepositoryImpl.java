package com.ghosttrio.judomanager.notice.adapter.port.out.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.ghosttrio.judomanager.notice.domain.QNotice.notice;

@RequiredArgsConstructor
public class NoticeCommandRepositoryImpl implements NoticeCommandRepository {

    private final JPAQueryFactory query;

    @Override
    public void update(Long noticeId, String title, String content) {
        query.update(notice)
                .set(notice.title, title)
                .set(notice.content, content)
                .where(notice.id.eq(noticeId))
                .execute();
    }
}
