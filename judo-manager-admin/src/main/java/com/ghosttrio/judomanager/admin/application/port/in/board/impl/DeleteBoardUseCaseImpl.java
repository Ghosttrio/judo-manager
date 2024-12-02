package com.ghosttrio.judomanager.admin.application.port.in.board.impl;

import com.ghosttrio.judomanager.admin.application.port.in.board.DeleteBoardUseCase;
import com.ghosttrio.judomanager.admin.application.service.DeleteBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteBoardUseCaseImpl implements DeleteBoardUseCase {

    private final DeleteBoardService deleteBoardService;

    @Override
    public void execute(Long boardId) {
        deleteBoardService.delete(boardId);
    }
}
