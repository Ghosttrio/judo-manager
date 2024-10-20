//package com.ghosttrio.judomanager.notice.notice.notice.repository;
//
//import com.ghosttrio.judomanager.notice.notice.notice.domain.Notice;
//import com.judomanager.domain.notice.domain.QNotice;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//
//import java.util.List;
//import java.util.Optional;
//
//import static com.judomanager.domain.notice.domain.QNotice.notice;
//
//
//@RequiredArgsConstructor
//public class NoticeQueryRepositoryImpl implements NoticeQueryRepository{
//
//    private final JPAQueryFactory query;
//
//    @Override
//    public List<Notice> findAllNoticeByDojoId(Long dojoId) {
//
//        return query.selectFrom(QNotice.notice)
//                .where(QNotice.notice.dojoId.eq(dojoId))
//                .fetch();
//    }
//
//    public Optional<Notice> checkTitleDuplicate(Long dojoId, String title){
//        Notice result = query.selectFrom(QNotice.notice)
//                .where(QNotice.notice.dojoId.eq(dojoId).and(QNotice.notice.title.eq(title)))
//                .fetchOne();
//        return Optional.ofNullable(result);
//    }
//}
