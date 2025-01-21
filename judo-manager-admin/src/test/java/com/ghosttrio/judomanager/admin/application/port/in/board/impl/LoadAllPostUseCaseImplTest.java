package com.ghosttrio.judomanager.admin.application.port.in.board.impl;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.board.model.Post;
import com.ghosttrio.judomanager.admin.application.service.LoadBoardService;
import com.ghosttrio.judomanager.admin.common.MonkeySupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoadAllPostUseCaseImplTest extends MonkeySupport {

    @InjectMocks
    private LoadAllPostUseCaseImpl loadAllPostUseCaseImpl;
    @Mock
    private LoadBoardService loadBoardService;

    @Test
    void 모든_게시글_조회_요청_서비스가_호출되어야_한다() {
        Long boardId = 1L;
        List<Post> posts = monkey.giveMe(Post.class, 3);
        when(loadBoardService.findAllByBoardId(boardId)).thenReturn(posts);
        loadAllPostUseCaseImpl.execute(boardId);
        verify(loadBoardService, times(1)).findAllByBoardId(boardId);
    }

}