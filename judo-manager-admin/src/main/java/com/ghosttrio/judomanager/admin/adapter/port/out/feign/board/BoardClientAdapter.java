package com.ghosttrio.judomanager.admin.adapter.port.out.feign.board;

import java.util.List;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.board.model.Post;
import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.admin.application.port.out.BoardClientPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BoardClientAdapter implements BoardClientPort {

	private final BoardFeignClient boardFeignClient;

	@Override
	public List<Post> findAllByBoardId(Long boardId) {
		return boardFeignClient.findAllByBoardId(boardId);
	}

	@Override
	public void deleteById(Long boardId) {
		boardFeignClient.deleteById(boardId);
	}
}
