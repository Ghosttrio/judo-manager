package com.judomanager.controller.user.notice;

import com.judomanager.common.JMResponse;
import com.judomanager.dto.notice.request.UpdateNoticeRequest;
import com.judomanager.service.notice.UpdateNoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UpdateNoticeController {

    private final UpdateNoticeService noticeService;

    @Tag(name = "도장별 공지사항 수정 API")
    @Operation(summary = "각 도장에 등록되어 있는 특정 공지사항을 수정한다.")
    @PatchMapping("/api/v1/notices/{noticeId}")
    public JMResponse<Void> updateNotice(@PathVariable Long noticeId,
                                         @RequestBody UpdateNoticeRequest request){
        noticeService.updateNotice(noticeId, request.title(), request.content());
        return JMResponse.ok();
    }
}
