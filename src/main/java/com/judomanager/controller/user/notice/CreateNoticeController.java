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

    @Tag(name = "도장별 공지사항 조회 API")
    @Operation(summary = "각 도장에 등록되어 있는 공지사항을 모두 조회한다.")
    @PostMapping("/{dojoId}")
    public JMResponse<Void> createNotice(@PathVariable Long dojoId,
                                   @RequestBody CreateNoticeRequest request){
        noticeService.saveNotice(dojoId, request.title(), request.content());
        return JMResponse.ok();
    }

}
