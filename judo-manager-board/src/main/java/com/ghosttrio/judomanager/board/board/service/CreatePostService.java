package com.ghosttrio.judomanager.board.board.service;

import com.ghosttrio.judomanager.board.board.domain.Post;
import com.ghosttrio.judomanager.board.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreatePostService {

    private final PostRepository postRepository;

    @Transactional
    public void createPost(Long boardId, String title, String content){
        Post post = Post.create(boardId, title, content);
        postRepository.save(post);
    }

}
