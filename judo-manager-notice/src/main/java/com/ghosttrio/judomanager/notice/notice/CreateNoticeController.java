package com.ghosttrio.judomanager.notice.notice;

import com.ghosttrio.judomanager.notice.notice.request.CreateNoticeRequest;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.notice.service.CreateNoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notices")
@Tag(name = "[Notice API]")
public class CreateNoticeController {

    private final CreateNoticeService noticeService;

    @Operation(summary = "각 도장에 등록되어 있는 공지사항을 모두 조회한다.")
    @PostMapping("/{dojoId}")
    public JMResponse<Void> createNotice(@PathVariable Long dojoId,
                                         @RequestBody CreateNoticeRequest request){
        noticeService.saveNotice(dojoId, request.title(), request.content());
        return JMResponse.ok();
    }

}
