package com.ghosttrio.judomanager.admin.application.port.out;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.board.model.Post;

import java.util.List;

public interface BoardClientPort {
    List<Post> findAllByBoardId(Long boardId);

    void deleteById(Long boardId);
}
