//package com.ghosttrio.judomanager.board.board.post;
//
//import com.judomanager.common.exception.JMResponse;
//import com.judomanager.domain.board.domain.Post;
//import com.judomanager.domain.board.service.LoadBoardService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/boards")
//@Tag(name = "[Board API]")
//public class LoadPostController {
//
//    private final LoadBoardService loadBoardService;
//
//    @Operation(summary = "게시판 특정 카테고리의 글을 모두 조회한다.")
//    @GetMapping("/{boardId}/posts")
//    public JMResponse<List<Post>> loadAllPost(@PathVariable Long boardId){
//        List<Post> result = loadBoardService.findAllPost(boardId);
//        return JMResponse.ok(result);
//    }
//
//    @Operation(summary = "게시판 특정 카테고리의 글 중 특정 글을 조회한다.")
//    @GetMapping("/posts/{postId}")
//    public JMResponse<Post> loadPost(@PathVariable Long postId){
//        Post result = loadBoardService.findPost(postId);
//        return JMResponse.ok(result);
//    }
//
//}
