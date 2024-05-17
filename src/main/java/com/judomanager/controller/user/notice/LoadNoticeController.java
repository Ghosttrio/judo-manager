package com.judomanager.controller.user.notice;

import com.judomanager.common.JMResponse;
import com.judomanager.domain.notice.Notice;
import com.judomanager.service.notice.LoadNoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoadNoticeController {

    private final LoadNoticeService noticeService;

    // 관리자페이지에서 추후 필요할때 사용
    @GetMapping("/api/v1/notices")
    public JMResponse<List<Notice>> loadAllNotice(){
        List<Notice> result = noticeService.findAllNotice();
        return JMResponse.ok(result);
    }

    // 도장별 공지사항 조회 API
    @GetMapping("/api/v1/notices/{dojoId}")
    public JMResponse<List<Notice>> loadAllNoticeByDojoId(@PathVariable Long dojoId){
        List<Notice> result = noticeService.findAllNoticeByDojoId(dojoId);
        return JMResponse.ok(result);
    }


}
