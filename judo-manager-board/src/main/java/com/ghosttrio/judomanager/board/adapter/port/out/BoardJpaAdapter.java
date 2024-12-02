package com.ghosttrio.judomanager.board.adapter.port.out;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.board.application.port.out.BoardJpaPort;
import com.ghosttrio.judomanager.board.domain.Board;
import com.ghosttrio.judomanager.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BoardJpaAdapter implements BoardJpaPort {

	private final BoardRepository boardRepository;
	private final BoardMapper boardMapper;

	@Override
	public List<Board> findAll() {
		return boardRepository.findAll().stream()
			.map(boardMapper::toDomain)
			.toList();
	}
}
