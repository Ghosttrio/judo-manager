package com.ghosttrio.judomanager.notice.adapter.port.out.jpa;

import com.ghosttrio.judomanager.notice.domain.Notice;
import com.ghosttrio.judomanager.notice.domain.QNotice;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.ghosttrio.judomanager.notice.domain.QNotice.notice;


@RequiredArgsConstructor
public class NoticeQueryRepositoryImpl implements NoticeQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<Notice> findAllNoticeByDojoId(Long dojoId) {

        return query.selectFrom(notice)
                .where(notice.dojoId.eq(dojoId))
                .fetch();
    }

    public Optional<Notice> checkTitleDuplicate(Long dojoId, String title){
        Notice result = query.selectFrom(notice)
                .where(notice.dojoId.eq(dojoId).and(notice.title.eq(title)))
                .fetchOne();
        return Optional.ofNullable(result);
    }
}
