package com.ghosttrio.judomanager.board.application.port.in.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.board.application.port.in.LoadAllBoardUseCase;
import com.ghosttrio.judomanager.board.application.service.LoadBoardService;
import com.ghosttrio.judomanager.board.domain.Board;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoadAllBoardUseCaseImpl implements LoadAllBoardUseCase {

	private final LoadBoardService loadBoardService;

	@Override
	public List<Board> execute() {
		return loadBoardService.findAll();
	}
}
