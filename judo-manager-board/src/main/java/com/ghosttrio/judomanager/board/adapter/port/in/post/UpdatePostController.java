package com.ghosttrio.judomanager.board.adapter.port.in.post;

import com.ghosttrio.judomanager.board.adapter.port.in.post.request.UpdatePostRequest;
import com.ghosttrio.judomanager.board.application.service.UpdatePostService;
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
public class UpdatePostController {

    private final UpdatePostService updatePostService;

    @Operation(summary = "게시판 글을 수정한다.")
    @PatchMapping("/posts/{postId}")
    public JMResponse<Void> createPost(@PathVariable Long postId,
                                       @RequestBody UpdatePostRequest request){
        updatePostService.updatePost(postId, request.title(), request.content());
        return JMResponse.ok();
    }

}
