package com.judomanager.service.board;

import com.judomanager.common.exception.ErrorCode;
import com.judomanager.common.exception.JMException;
import com.judomanager.domain.board.Post;
import com.judomanager.repository.board.PostRepository;
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
        Post post = postRepository.findById(postId).orElseThrow(() -> new JMException(POST_NOT_FOUND));
        post.update(title, content);
    }


}
