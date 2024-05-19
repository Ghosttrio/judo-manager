package com.judomanager.controller.user.board.post;

import com.judomanager.common.JMResponse;
import com.judomanager.domain.board.Post;
import com.judomanager.service.board.LoadBoardService;
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
@Tag(name = "게시판 글 조회 컨트롤러")
public class LoadPostController {

    private final LoadBoardService loadBoardService;

    @GetMapping("/{boardId}/posts")
    public JMResponse<List<Post>> loadAllPost(@PathVariable Long boardId){
        List<Post> result = loadBoardService.findAllPost(boardId);
        return JMResponse.ok(result);
    }

    @GetMapping("/posts/{postId}")
    public JMResponse<Post> loadPost(@PathVariable Long postId){
        Post result = loadBoardService.findPost(postId);
        return JMResponse.ok(result);
    }

}
