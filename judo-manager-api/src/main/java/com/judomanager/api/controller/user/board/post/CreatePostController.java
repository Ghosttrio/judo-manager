package com.judomanager.api.controller.user.board.post;

import com.judomanager.api.dto.board.CreatePostRequest;
import com.judomanager.common.common.JMResponse;
import com.judomanager.domain.service.board.CreatePostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
@Tag(name = "게시판 글 생성 컨트롤러")
public class CreatePostController {

    private final CreatePostService createPostService;

    @Tag(name = "게시글 생성 API")
    @Operation(summary = "게시판 특정 카테고리에 글을 생성한다.")
    @PostMapping("/{boardId}/posts")
    public JMResponse<Void> createPost(@PathVariable Long boardId,
                                 @RequestBody CreatePostRequest request){
        createPostService.createPost(boardId, request.title(), request.content());
        return JMResponse.ok();
    }



}
