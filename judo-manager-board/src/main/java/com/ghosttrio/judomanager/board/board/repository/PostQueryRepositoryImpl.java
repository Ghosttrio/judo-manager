package com.ghosttrio.judomanager.board.board.repository;

import com.ghosttrio.judomanager.board.board.domain.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.judomanager.domain.board.domain.QPost.post;


@RequiredArgsConstructor
public class PostQueryRepositoryImpl implements PostQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<Post> findAllPostByBoardId(Long boardId) {
        return query.selectFrom(QPost.post)
                .where(QPost.post.boardId.eq(boardId))
                .fetch();
    }

}
