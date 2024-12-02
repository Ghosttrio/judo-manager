package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.application.port.out.BoardClientPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteBoardServiceTest {

    @Mock
    private BoardClientPort boardClientPort;
    @Mock
    private CircuitBreakerFactory circuitBreakerFactory;
    @Mock
    private CircuitBreaker circuitBreaker;
    @InjectMocks
    private DeleteBoardService deleteBoardService;


    @Test
    void 서킷브레이커를_거쳐서_게시글_정보를_삭제성공() {
        //given
        Long boardId = 1L;
        when(circuitBreakerFactory.create("boardCB")).thenReturn(circuitBreaker);
        // 일반적으로 doAnswer는 void 반환 타입의 메서드나 예외를 던지는 메서드의 동작을 정의할 때 사용
        doAnswer(invocation -> {
            Supplier<Void> deleteAction = invocation.getArgument(0);
            deleteAction.get();
            return null;
        }).when(circuitBreaker).run(any(Supplier.class));
        doNothing().when(boardClientPort).deleteById(boardId);

        //when
        deleteBoardService.delete(boardId);

        //then
        verify(boardClientPort, times(1)).deleteById(boardId);
    }

    @Test
    public void 서킷브레이커를_거쳐서_게시글_정보를_삭제실패() {
        Long boardId = 1L;
        when(circuitBreakerFactory.create("boardCB")).thenReturn(circuitBreaker);
        doThrow(new RuntimeException("서비스 에러")).when(circuitBreaker).run(any(Supplier.class));
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> deleteBoardService.delete(boardId));
        assertEquals("서비스 에러", exception.getMessage());
        verify(boardClientPort, never()).deleteById(boardId);
    }
}