package com.ghosttrio.judomanager.board.board.service;

import com.ghosttrio.judomanager.board.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeletePostService {

    private final PostRepository postRepository;

    @Transactional
    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }
}
