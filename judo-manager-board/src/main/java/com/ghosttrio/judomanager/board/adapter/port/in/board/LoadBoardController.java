package com.ghosttrio.judomanager.board.adapter.port.in.board;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghosttrio.judomanager.board.application.port.in.LoadAllBoardUseCase;
import com.ghosttrio.judomanager.board.common.exception.JMResponse;
import com.ghosttrio.judomanager.board.domain.Board;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class LoadBoardController {

	private final LoadAllBoardUseCase loadAllBoardUseCase;

	@GetMapping
	public JMResponse<List<Board>> loadAllBoard() {
		List<Board> result = loadAllBoardUseCase.execute();
		return JMResponse.ok(result);
	}
}
