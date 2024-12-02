package com.ghosttrio.judomanager.board.adapter.port.out;

import java.util.List;

import com.ghosttrio.judomanager.board.adapter.port.out.entity.PostEntity;

public interface PostQueryRepository {

	List<PostEntity> findAllPostByBoardId(Long boardId);
}
