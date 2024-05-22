package com.judomanager.domain.board.repository;

import com.judomanager.domain.board.domain.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.judomanager.domain.board.domain.QPost.post;


@RequiredArgsConstructor
public class PostQueryRepositoryImpl implements PostQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<Post> findAllPostByBoardId(Long boardId) {
        return query.selectFrom(post)
                .where(post.boardId.eq(boardId))
                .fetch();
    }

}
