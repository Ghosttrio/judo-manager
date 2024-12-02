package com.ghosttrio.judomanager.notice.adapter.port.in.request;

public record UpdateNoticeRequest(
        String title,
        String content
) {
}
