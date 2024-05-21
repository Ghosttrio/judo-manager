package com.judomanager.domain.service.board;

import com.judomanager.domain.domain.board.Post;
import com.judomanager.domain.repository.board.PostRepository;
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
