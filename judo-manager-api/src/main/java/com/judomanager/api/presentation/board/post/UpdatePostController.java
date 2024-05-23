package com.judomanager.api.presentation.board.post;

import com.judomanager.api.presentation.board.post.dto.UpdatePostRequest;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.board.service.UpdatePostService;
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
