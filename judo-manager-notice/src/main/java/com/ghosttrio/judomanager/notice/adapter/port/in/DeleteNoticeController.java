package com.ghosttrio.judomanager.notice.adapter.port.in;

import com.ghosttrio.judomanager.notice.application.port.in.DeleteNoticeUseCase;
import com.ghosttrio.judomanager.notice.common.exception.JMResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "[Notice API]")
public class DeleteNoticeController {

    private final DeleteNoticeUseCase deleteNoticeUseCase;

    @Operation(summary = "각 도장에 등록되어 있는 특정 공지사항을 삭제한다.")
    @DeleteMapping("/api/v1/notices/{noticeId}")
    public JMResponse<Void> deleteNotice(@PathVariable Long noticeId){
        deleteNoticeUseCase.execute(noticeId);
        return JMResponse.ok();
    }
}
