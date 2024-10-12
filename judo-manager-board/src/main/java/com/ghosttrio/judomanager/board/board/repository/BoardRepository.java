package com.ghosttrio.judomanager.board.board.repository;

import com.ghosttrio.judomanager.board.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
