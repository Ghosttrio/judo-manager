package com.judomanager.repository.user;

import com.judomanager.domain.user.QUser;
import com.judomanager.domain.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.judomanager.domain.user.QUser.user;


@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<User> findAllUserByDojoId(Long dojoId) {
        return query.selectFrom(user).where(user.dojoId.eq(dojoId)).fetch();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(query.selectFrom(user).where(user.email.eq(email)).fetchOne());
    }
}
