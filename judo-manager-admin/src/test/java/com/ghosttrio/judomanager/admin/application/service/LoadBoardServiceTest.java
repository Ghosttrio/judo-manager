package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.board.model.Post;
import com.ghosttrio.judomanager.admin.application.port.out.BoardClientPort;
import com.ghosttrio.judomanager.admin.common.MonkeySupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoadBoardServiceTest extends MonkeySupport {

    @Mock
    private BoardClientPort boardClientPort;
    @Mock
    private CircuitBreakerFactory circuitBreakerFactory;
    @Mock
    private CircuitBreaker circuitBreaker;
    @InjectMocks
    private LoadBoardService loadBoardService;

    @Test
    void 게시글_조회_로직이_성공해야_한다() {
        Long boardId = 1L;
        List<Post> posts = monkey.giveMe(Post.class, 3);
        when(circuitBreakerFactory.create("boardCB")).thenReturn(circuitBreaker);
        when(circuitBreaker.run(any(), any())).thenReturn(posts);
        List<Post> result = loadBoardService.findAllByBoardId(boardId);
        assertNotNull(result);
    }

    @Test
    void 게시글_모듈이_응답을_하지_않을_경우_빈객체_배열을_리턴한다() {
        Long boardId = 1L;
        when(circuitBreakerFactory.create("boardCB")).thenReturn(circuitBreaker);
        when(circuitBreaker.run(any(), any())).thenThrow(new RuntimeException("Service unavailable"));
        assertThrows(Exception.class, () -> loadBoardService.findAllByBoardId(boardId));
    }
}