//package com.ghosttrio.judomanager.user.user.user.repository;
//
//import com.ghosttrio.judomanager.user.user.user.domain.User;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//
//import java.util.List;
//import java.util.Optional;
//
//import static com.judomanager.domain.user.domain.QUser.user;
//
//
//@RequiredArgsConstructor
//public class UserQueryRepositoryImpl implements UserQueryRepository {
//
//    private final JPAQueryFactory query;
//
//    @Override
//    public List<User> findAllUserByDojoId(Long dojoId) {
//        return query.selectFrom(QUser.user).where(QUser.user.dojoId.eq(dojoId)).fetch();
//    }
//
//    @Override
//    public Optional<User> findByEmail(String email) {
//        return Optional.ofNullable(query.selectFrom(QUser.user).where(QUser.user.email.eq(email)).fetchOne());
//    }
//}
