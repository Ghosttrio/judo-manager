package com.ghosttrio.judomanager.board.application.port.in;

import java.util.List;

import com.ghosttrio.judomanager.board.domain.Board;

public interface LoadAllBoardUseCase {
	List<Board> execute();
}
