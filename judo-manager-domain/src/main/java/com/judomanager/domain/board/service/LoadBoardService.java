package com.judomanager.domain.board.service;

import com.judomanager.common.exception.JMException;
import com.judomanager.domain.board.domain.Post;
import com.judomanager.domain.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.judomanager.common.exception.ErrorCode.POST_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadBoardService {
    private final PostRepository postRepository;

    public List<Post> findAllPost(Long boardId){
        return postRepository.findAllPostByBoardId(boardId);
    }

    public Post findPost(Long postId){
        return postRepository.findById(postId)
                .orElseThrow(() -> new JMException(POST_NOT_FOUND));
    }
}
