package com.judomanager.repository.board;

import com.judomanager.domain.board.Post;

import java.util.List;

public interface PostQueryRepository {

    List<Post> findAllPostByBoardId(Long boardId);
}
