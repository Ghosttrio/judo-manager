package com.ghosttrio.judomanager.admin.adapter.port.in;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.board.model.Post;
import com.ghosttrio.judomanager.admin.application.port.in.board.DeleteBoardUseCase;
import com.ghosttrio.judomanager.admin.application.port.in.board.LoadAllPostUseCase;
import com.ghosttrio.judomanager.admin.config.exception.JMResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admins/boards")
@Tag(name = "[ADMIN API]")
public class BoardController {

    private final LoadAllPostUseCase loadAllPostUseCase;
    private final DeleteBoardUseCase deleteBoardUseCase;

    @Operation(summary = "유도 매니저에 등록된 게시판의 모든 게시글을 조회한다.")
    @GetMapping("/{boardId}/posts")
    public JMResponse<List<Post>> loadAllPost(@PathVariable Long boardId) {
        List<Post> result = loadAllPostUseCase.execute(boardId);
        return JMResponse.ok(result);
    }

    @Operation(summary = "유도 매니저에 등록된 특정 게시글을 삭제한다.")
    @GetMapping("/{boardId}")
    public JMResponse<Void> deletePost(@PathVariable Long boardId) {
        deleteBoardUseCase.execute(boardId);
        return JMResponse.ok();
    }

}
