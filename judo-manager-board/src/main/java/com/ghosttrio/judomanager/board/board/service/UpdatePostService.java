package com.ghosttrio.judomanager.board.board.service;

import com.ghosttrio.judomanager.board.board.domain.Post;
import com.judomanager.common.exception.JMException;
import com.ghosttrio.judomanager.board.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.judomanager.common.exception.ErrorCode.POST_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UpdatePostService {

    private final PostRepository postRepository;

    @Transactional
    public void updatePost(Long postId, String title, String content){
        Post post = postRepository.findById(postId).orElseThrow(() -> new JMException(ErrorCode.POST_NOT_FOUND));
        post.update(title, content);
    }


}
