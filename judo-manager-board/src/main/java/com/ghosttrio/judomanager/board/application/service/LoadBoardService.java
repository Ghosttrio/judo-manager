package com.ghosttrio.judomanager.board.application.service;

import com.ghosttrio.judomanager.board.adapter.port.out.BoardRepository;
import com.ghosttrio.judomanager.board.adapter.port.out.PostRepository;
import com.ghosttrio.judomanager.board.adapter.port.out.entity.BoardEntity;
import com.ghosttrio.judomanager.board.adapter.port.out.entity.PostEntity;
import com.ghosttrio.judomanager.board.application.port.out.BoardJpaPort;
import com.ghosttrio.judomanager.board.common.exception.ErrorCode;
import com.ghosttrio.judomanager.board.common.exception.JMException;
import com.ghosttrio.judomanager.board.domain.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadBoardService {
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final BoardJpaPort boardJpaPort;

    public List<PostEntity> findAllPost(Long boardId){
        return postRepository.findAllPostByBoardId(boardId);
    }

    public PostEntity findPost(Long postId){
        return postRepository.findById(postId)
                .orElseThrow(() -> new JMException(ErrorCode.POST_NOT_FOUND));
    }

    public List<Board> findAll(){
        return boardJpaPort.findAll();
    }

}
