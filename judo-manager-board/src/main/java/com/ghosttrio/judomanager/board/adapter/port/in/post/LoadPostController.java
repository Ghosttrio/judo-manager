package com.ghosttrio.judomanager.board.adapter.port.in.post;

import com.ghosttrio.judomanager.board.adapter.port.out.entity.PostEntity;
import com.ghosttrio.judomanager.board.application.service.LoadBoardService;
import com.ghosttrio.judomanager.board.common.exception.JMResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
@Tag(name = "[Board API]")
public class LoadPostController {

    private final LoadBoardService loadBoardService;

    @Operation(summary = "게시판 특정 카테고리의 글을 모두 조회한다.")
    @GetMapping("/{boardId}/posts")
    public JMResponse<List<PostEntity>> loadAllPost(@PathVariable Long boardId){
        List<PostEntity> result = loadBoardService.findAllPost(boardId);
        return JMResponse.ok(result);
    }

    @Operation(summary = "게시판 특정 카테고리의 글 중 특정 글을 조회한다.")
    @GetMapping("/posts/{postId}")
    public JMResponse<PostEntity> loadPost(@PathVariable Long postId){
        PostEntity result = loadBoardService.findPost(postId);
        return JMResponse.ok(result);
    }

}
