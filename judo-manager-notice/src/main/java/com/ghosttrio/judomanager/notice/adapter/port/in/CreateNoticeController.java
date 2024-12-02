package com.ghosttrio.judomanager.notice.adapter.port.in;

import com.ghosttrio.judomanager.notice.adapter.port.in.request.CreateNoticeRequest;
import com.ghosttrio.judomanager.notice.application.port.in.CreateNoticeUseCase;
import com.ghosttrio.judomanager.notice.common.exception.JMResponse;
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

    private final CreateNoticeUseCase createNoticeUseCase;

    @Operation(summary = "각 도장에 등록되어 있는 공지사항을 모두 조회한다.")
    @PostMapping("/{dojoId}")
    public JMResponse<Void> createNotice(@PathVariable Long dojoId,
                                         @RequestBody CreateNoticeRequest request){
        createNoticeUseCase.execute(dojoId, request.title(), request.content());
        return JMResponse.ok();
    }

}
