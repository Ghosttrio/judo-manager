package com.judomanager.service.board;

import com.judomanager.repository.board.PostRepository;
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
