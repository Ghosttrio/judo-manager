package com.ghosttrio.judomanager.admin.adapter.port.out.feign.board;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.board.model.Post;
import com.ghosttrio.judomanager.admin.common.MonkeySupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BoardClientAdapterTest extends MonkeySupport {

    @InjectMocks
    private BoardClientAdapter boardClientAdapter;
    @Mock
    private BoardFeignClient boardFeignClient;

    @Test
    void 게시글_전체_조회_요청이_성공해야_한다() {
        Long boardId = 1L;
        List<Post> posts = monkey.giveMe(Post.class, 3);
        when(boardFeignClient.findAllByBoardId(boardId)).thenReturn(posts);

        boardClientAdapter.findAllByBoardId(boardId);

        verify(boardFeignClient, times(1)).findAllByBoardId(boardId);
    }

    @Test
    void 게시글_삭제_요청이_성공해야_한다() {
        Long boardId = 1L;

        boardClientAdapter.deleteById(boardId);

        verify(boardFeignClient, times(1)).deleteById(boardId);
    }
}