package com.ghosttrio.judomanager.notice.adapter.port.in;

import com.ghosttrio.judomanager.notice.application.port.in.LoadAllNoticeUseCase;
import com.ghosttrio.judomanager.notice.application.port.in.LoadNoticeByDojoUseCase;
import com.ghosttrio.judomanager.notice.application.service.LoadNoticeService;
import com.ghosttrio.judomanager.notice.common.exception.JMResponse;
import com.ghosttrio.judomanager.notice.domain.Notice;
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
@Tag(name = "[Notice API]")
public class LoadNoticeController {

    private final LoadAllNoticeUseCase loadAllNoticeUseCase;
    private final LoadNoticeByDojoUseCase loadNoticeByDojoUseCase;


    @Operation(summary = "등록되어 있는 공지사항을 모두 조회한다.")
    @GetMapping("/api/v1/notices")
    public JMResponse<List<Notice>> loadAllNotice(){
        List<Notice> result = loadAllNoticeUseCase.execute();
        return JMResponse.ok(result);
    }

    @Operation(summary = "각 도장에 등록되어 있는 특정 공지사항을 조회한다.")
    @GetMapping("/api/v1/notices/{dojoId}")
    public JMResponse<List<Notice>> loadAllNoticeByDojoId(@PathVariable Long dojoId){
        List<Notice> result = loadNoticeByDojoUseCase.execute(dojoId);
        return JMResponse.ok(result);
    }

}
