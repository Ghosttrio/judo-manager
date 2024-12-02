package com.ghosttrio.judomanager.board.application.service;

import com.ghosttrio.judomanager.board.adapter.port.out.PostRepository;
import com.ghosttrio.judomanager.board.adapter.port.out.entity.PostEntity;
import com.ghosttrio.judomanager.board.common.exception.ErrorCode;
import com.ghosttrio.judomanager.board.common.exception.JMException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UpdatePostService {

    private final PostRepository postRepository;

    @Transactional
    public void updatePost(Long postId, String title, String content){
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new JMException(ErrorCode.POST_NOT_FOUND));
        postEntity.update(title, content);
    }
}
