package com.ghosttrio.judomanager.notice.adapter.port.in;

import com.ghosttrio.judomanager.notice.adapter.port.in.request.UpdateNoticeRequest;
import com.ghosttrio.judomanager.notice.application.port.in.UpdateNoticeUseCase;
import com.ghosttrio.judomanager.notice.application.service.UpdateNoticeService;
import com.ghosttrio.judomanager.notice.common.exception.JMResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "[Notice API]")
public class UpdateNoticeController {

    private final UpdateNoticeUseCase updateNoticeUseCase;

    @Operation(summary = "각 도장에 등록되어 있는 특정 공지사항을 수정한다.")
    @PatchMapping("/api/v1/notices/{noticeId}")
    public JMResponse<Void> updateNotice(@PathVariable Long noticeId,
                                         @RequestBody UpdateNoticeRequest request){
        updateNoticeUseCase.execute(noticeId, request.title(), request.content());
        return JMResponse.ok();
    }
}
