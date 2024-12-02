package com.ghosttrio.judomanager.notice.adapter.port.in.request;


public record CreateNoticeRequest(
        String title,
        String content
) {
}
