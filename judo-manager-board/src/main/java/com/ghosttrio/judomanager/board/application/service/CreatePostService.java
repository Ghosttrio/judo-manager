package com.ghosttrio.judomanager.board.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghosttrio.judomanager.board.adapter.port.out.PostRepository;
import com.ghosttrio.judomanager.board.adapter.port.out.entity.PostEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreatePostService {

	private final PostRepository postRepository;

	@Transactional
	public void createPost(Long boardId, String title, String content) {
		PostEntity postEntity = PostEntity.create(boardId, title, content);
		postRepository.save(postEntity);
	}

}
