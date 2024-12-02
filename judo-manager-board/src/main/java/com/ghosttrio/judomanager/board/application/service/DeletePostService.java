package com.ghosttrio.judomanager.board.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghosttrio.judomanager.board.adapter.port.out.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeletePostService {

	private final PostRepository postRepository;

	@Transactional
	public void deletePost(Long postId) {
		postRepository.deleteById(postId);
	}
}
