package com.judomanager.api.presentation.notice;

import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.notice.domain.Notice;
import com.judomanager.domain.notice.service.LoadNoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Tag(name = "[미사용] 공지사항 전체 조회 API")
    @Operation(summary = "등록되어 있는 공지사항을 모두 조회한다.")
    @GetMapping("/api/v1/notices")
    public JMResponse<List<Notice>> loadAllNotice(){
        List<Notice> result = noticeService.findAllNotice();
        return JMResponse.ok(result);
    }

    @Tag(name = "도장별 공지사항 조회 API")
    @Operation(summary = "각 도장에 등록되어 있는 특정 공지사항을 조회한다.")
    @GetMapping("/api/v1/notices/{dojoId}")
    public JMResponse<List<Notice>> loadAllNoticeByDojoId(@PathVariable Long dojoId){
        List<Notice> result = noticeService.findAllNoticeByDojoId(dojoId);
        return JMResponse.ok(result);
    }

}
