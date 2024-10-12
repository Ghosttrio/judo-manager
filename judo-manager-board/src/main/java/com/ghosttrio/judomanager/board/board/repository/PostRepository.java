package com.ghosttrio.judomanager.board.board.repository;

import com.ghosttrio.judomanager.board.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostQueryRepository {
}
