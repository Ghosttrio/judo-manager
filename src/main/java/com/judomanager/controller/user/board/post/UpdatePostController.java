package com.judomanager.controller.user.board.post;

import com.judomanager.common.JMResponse;
import com.judomanager.dto.board.UpdatePostRequest;
import com.judomanager.service.board.UpdatePostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
@Tag(name = "게시판 글 수정 컨트롤러")
public class UpdatePostController {

    private final UpdatePostService updatePostService;

    @Tag(name = "게시글 수정 API")
    @Operation(summary = "게시판 글을 수정한다.")
    @PatchMapping("/posts/{postId}")
    public JMResponse<Void> createPost(@PathVariable Long postId,
                                       @RequestBody UpdatePostRequest request){
        updatePostService.updatePost(postId, request.title(), request.content());
        return JMResponse.ok();
    }

}
