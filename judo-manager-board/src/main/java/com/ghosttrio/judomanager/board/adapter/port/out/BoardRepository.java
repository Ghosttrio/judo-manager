package com.ghosttrio.judomanager.board.adapter.port.out;

import com.ghosttrio.judomanager.board.adapter.port.out.entity.BoardEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
