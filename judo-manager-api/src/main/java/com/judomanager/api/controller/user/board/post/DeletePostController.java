package com.judomanager.api.controller.user.board.post;

import com.judomanager.common.common.JMResponse;
import com.judomanager.domain.service.board.DeletePostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
@Tag(name = "게시판 글 삭제 컨트롤러")
public class DeletePostController {

    private final DeletePostService deletePostService;

    @Tag(name = "게시글 삭제 API")
    @Operation(summary = "게시판 특정 카테고리에 글을 삭제한다.")
    @DeleteMapping("/posts/{postId}")
    public JMResponse<Void> createPost(@PathVariable Long postId){
        deletePostService.deletePost(postId);
        return JMResponse.ok();
    }
}
