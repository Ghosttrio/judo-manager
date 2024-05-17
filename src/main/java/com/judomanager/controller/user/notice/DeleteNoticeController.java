package com.judomanager.controller.user.notice;

import com.judomanager.common.JMResponse;
import com.judomanager.service.notice.DeleteNoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DeleteNoticeController {

    private final DeleteNoticeService noticeService;

    // 도장별 공지사항 삭제
    @DeleteMapping("/api/v1/notices/{noticeId}")
    public JMResponse<Void> deleteNotice(@PathVariable Long noticeId){
        noticeService.deleteNotice(noticeId);
        return JMResponse.ok();
    }
}
