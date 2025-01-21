package com.ghosttrio.judomanager.admin.application.port.in.board.impl;

import com.ghosttrio.judomanager.admin.application.service.DeleteBoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteBoardUseCaseImplTest {

    @InjectMocks
    private DeleteBoardUseCaseImpl deleteBoardUseCase;
    @Mock
    private DeleteBoardService deleteBoardService;

    @Test
    void 게시글_삭제_요청_서비스가_호출되어야_한다() {
        Long boardId = 1L;
        doNothing().when(deleteBoardService).delete(boardId);
        deleteBoardUseCase.execute(boardId);
        verify(deleteBoardService, times(1)).delete(boardId);
    }
}