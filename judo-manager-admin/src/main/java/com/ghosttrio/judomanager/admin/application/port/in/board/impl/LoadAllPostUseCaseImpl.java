package com.ghosttrio.judomanager.admin.application.port.in.board.impl;

import java.util.List;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.board.model.Post;
import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.admin.application.port.in.board.LoadAllPostUseCase;
import com.ghosttrio.judomanager.admin.application.service.LoadBoardService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoadAllPostUseCaseImpl implements LoadAllPostUseCase {

	private final LoadBoardService loadBoardService;

	@Override
	public List<Post> execute(Long boardId) {
		return loadBoardService.findAllByBoardId(boardId);
	}
}
