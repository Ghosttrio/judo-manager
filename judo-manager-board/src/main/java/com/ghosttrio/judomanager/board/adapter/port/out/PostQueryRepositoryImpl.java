package com.ghosttrio.judomanager.board.adapter.port.out;

import static com.ghosttrio.judomanager.board.domain.QPost.*;

import java.util.List;

import com.ghosttrio.judomanager.board.adapter.port.out.entity.PostEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostQueryRepositoryImpl implements PostQueryRepository {

	private final JPAQueryFactory query;

	@Override
	public List<PostEntity> findAllPostByBoardId(Long boardId) {
		return query.selectFrom(post)
			.where(post.boardId.eq(boardId))
			.fetch();
	}

}
