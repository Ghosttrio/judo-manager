package com.ghosttrio.judomanager.board.board.repository;



import com.ghosttrio.judomanager.board.board.domain.Post;

import java.util.List;

public interface PostQueryRepository {

    List<Post> findAllPostByBoardId(Long boardId);
}
