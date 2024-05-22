package com.judomanager.domain.board.repository;



import com.judomanager.domain.board.domain.Post;

import java.util.List;

public interface PostQueryRepository {

    List<Post> findAllPostByBoardId(Long boardId);
}
