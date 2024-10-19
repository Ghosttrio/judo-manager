//package com.ghosttrio.judomanager.dojo.dojo.repository.lesson;
//
//import com.ghosttrio.judomanager.dojo.dojo.domain.Lesson;
//import com.judomanager.domain.dojo.domain.QLesson;
//import com.judomanager.domain.dojo.domain.QPass;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//
//import java.util.Optional;
//
//import static com.judomanager.domain.dojo.domain.QLesson.lesson;
//import static com.judomanager.domain.dojo.domain.QPass.pass;
//
//
//@RequiredArgsConstructor
//public class LessonQueryRepositoryImpl implements LessonQueryRepository{
//
//    private final JPAQueryFactory query;
//
//
//    @Override
//    public Optional<Lesson> findByUserId(Long userId) {
//        return Optional.ofNullable(
//                query.selectFrom(lesson)
//                        .innerJoin(pass).on(pass.lessonId.eq(lesson.id))
//                        .where(pass.userId.eq(userId))
//                        .fetchOne());
//    }
//}
