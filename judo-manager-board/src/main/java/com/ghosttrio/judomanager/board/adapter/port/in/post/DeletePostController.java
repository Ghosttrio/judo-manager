package com.ghosttrio.judomanager.board.adapter.port.in.post;

import com.ghosttrio.judomanager.board.application.service.DeletePostService;
import com.ghosttrio.judomanager.board.common.exception.JMResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
@Tag(name = "[Board API]")
public class DeletePostController {

    private final DeletePostService deletePostService;

    @Operation(summary = "게시판 특정 카테고리에 글을 삭제한다.")
    @DeleteMapping("/posts/{postId}")
    public JMResponse<Void> createPost(@PathVariable Long postId){
        deletePostService.deletePost(postId);
        return JMResponse.ok();
    }
}
