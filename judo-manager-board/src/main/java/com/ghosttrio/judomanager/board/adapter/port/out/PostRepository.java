package com.ghosttrio.judomanager.board.adapter.port.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghosttrio.judomanager.board.adapter.port.out.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long>, PostQueryRepository {
}
