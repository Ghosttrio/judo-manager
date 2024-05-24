package com.judomanager.admin.board;

import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.board.domain.Board;
import com.judomanager.domain.board.service.LoadBoardService;
import com.judomanager.domain.dojo.domain.Dojo;
import com.judomanager.domain.dojo.service.LoadDojoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/v1/dojos")
@Tag(name = "관리자 게시글 조회 컨트롤러")
public class LoadBoardController {

    private final LoadBoardService loadBoardService;

    @Tag(name = "관리자 게시글 전체 조회 API")
    @Operation(summary = "유도 매니저에 등록된 모든 게시글을 조회한다.")
    @GetMapping
    public JMResponse<List<Board>> loadAllBoard(){
        List<Board> result = loadBoardService.findAll();
        return JMResponse.ok(result);
    }

}
