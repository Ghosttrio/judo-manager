package com.ghosttrio.judomanager.board.application.port.out;

import java.util.List;

import com.ghosttrio.judomanager.board.domain.Board;

public interface BoardJpaPort {
	List<Board> findAll();
}
