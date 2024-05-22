package com.judomanager.api.presentation.notice;

import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.notice.service.DeleteNoticeService;
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
@Tag(name = "공지사항 삭제 컨트롤러")
public class DeleteNoticeController {

    private final DeleteNoticeService noticeService;

    @Tag(name = "도장별 공지사항 삭제 API")
    @Operation(summary = "각 도장에 등록되어 있는 특정 공지사항을 삭제한다.")
    @DeleteMapping("/api/v1/notices/{noticeId}")
    public JMResponse<Void> deleteNotice(@PathVariable Long noticeId){
        noticeService.deleteNotice(noticeId);
        return JMResponse.ok();
    }
}
