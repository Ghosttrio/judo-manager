package com.ghosttrio.judomanager.admin.application.port.in.board;

import java.util.List;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.board.model.Board;
import com.ghosttrio.judomanager.admin.adapter.port.out.feign.board.model.Post;

public interface LoadAllPostUseCase {
	List<Post> execute(Long boardId);
}
