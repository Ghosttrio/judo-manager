package com.judomanager.controller.user.notice;

import com.judomanager.common.JMResponse;
import com.judomanager.common.exception.ErrorResponse;
import com.judomanager.dto.notice.request.CreateNoticeRequest;
import com.judomanager.service.notice.CreateNoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notices")
@Tag(name = "공지사항 생성 컨트롤러")
public class CreateNoticeController {

    private final CreateNoticeService noticeService;

    @Operation(summary = "도장별 공지사항 조회 API", responses = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "400", description = "실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PostMapping("/{dojoId}")
    public JMResponse<Void> createNotice(@PathVariable Long dojoId,
                                   @RequestBody CreateNoticeRequest request){
        noticeService.saveNotice(dojoId, request.title(), request.content());
        return JMResponse.ok();
    }

}
