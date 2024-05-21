package com.judomanager.domain.repository.board;


import com.judomanager.domain.domain.board.Post;

import java.util.List;

public interface PostQueryRepository {

    List<Post> findAllPostByBoardId(Long boardId);
}
