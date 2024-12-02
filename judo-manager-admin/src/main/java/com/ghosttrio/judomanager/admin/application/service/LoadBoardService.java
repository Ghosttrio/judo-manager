package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.board.model.Post;
import com.ghosttrio.judomanager.admin.application.port.out.BoardClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadBoardService {

    private final BoardClientPort boardClientPort;
    private final CircuitBreakerFactory circuitBreakerFactory;

    public List<Post> findAllByBoardId(Long boardId) {
        CircuitBreaker cb = circuitBreakerFactory.create("boardCB");
        return cb.run(() -> boardClientPort.findAllByBoardId(boardId), throwable -> List.of(new Post()));
    }

}
