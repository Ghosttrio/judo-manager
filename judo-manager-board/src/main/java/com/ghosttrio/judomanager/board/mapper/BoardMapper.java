package com.ghosttrio.judomanager.board.mapper;

import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.board.adapter.port.out.entity.BoardEntity;
import com.ghosttrio.judomanager.board.domain.Board;

@Component
public class BoardMapper {

	public Board toDomain(BoardEntity boardEntity) {
		return Board.create(boardEntity.getId(), boardEntity.getName());
	}
}
